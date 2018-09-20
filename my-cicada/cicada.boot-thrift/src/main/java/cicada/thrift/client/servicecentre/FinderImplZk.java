package cicada.thrift.client.servicecentre;


import cicada.core.Guard;
import cicada.core.RandomUtil;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class FinderImplZk implements Finder, Watcher {
    private static final Logger log = LoggerFactory.getLogger(FinderImplZk.class);
    private static final int repairInterval = 120;
    private static final int timeout = 50000;
    private final ConcurrentHashMap<String, Consumer<List<String>>> _actions = new ConcurrentHashMap();
    private ZooKeeper _zooKeeper;
    private String _respository;

    public FinderImplZk() {
    }

    public void init(String respository) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(respository, "respository");
        this._respository = respository;

        try {
            if (this._zooKeeper == null) {
                this.create();
            }
        } catch (Exception var3) {
            this.logException(var3);
            this.startRepair();
        }

    }

    private void startRepair() {
    }

    private void create() throws Exception {
        String[] array = this._respository.split(",");
        int radomNum = RandomUtil.GetRandomNext(array.length);
        String address = array[radomNum];
        this._zooKeeper = new ZooKeeper(address, 50000, this);
        int num = 10;
        ZooKeeper.States states = this._zooKeeper.getState();

        while(!states.equals(ZooKeeper.States.NOT_CONNECTED) && num-- > 1 && !this._zooKeeper.getState().equals(ZooKeeper.States.CONNECTED)) {
            Thread.sleep(1000L);
        }

        if (!this._zooKeeper.getState().equals(ZooKeeper.States.CONNECTED)) {
            throw new Exception(String.format("连接服务中心时发生超时，zookeeper地址为:%s", this._respository));
        }
    }

    private String logException(Exception ex) {
        String text;
        if (ex instanceof KeeperException.ConnectionLossException) {
            text = String.format("无法连接到服务中心，zookeeper地址为:%s", this._respository);
        } else if (ex instanceof KeeperException.SessionExpiredException) {
            text = String.format("连接服务中心时发生超时，zookeeper地址为:%s", this._respository);
        } else {
            text = String.format("zookeeper获取节点数据出现异常，zookeeper地址为:%s ", this._respository);
        }

        log.error(text);
        return text;
    }

    public void process(WatchedEvent event) {
        if (log.isDebugEnabled()) {
            String logText = String.format("ZooKeeper 状态发生更改 RPC路径：%s 服务中心地址：%s event.type:%s event.state%s", event.getPath(), this._respository, event.getType(), event.getState());
            log.debug(logText);
        }

        Event.KeeperState state = event.getState();
        if (state != Event.KeeperState.Expired) {
            String path = event.getPath();

            try {
                if (path == null || path.isEmpty()) {
                    return;
                }

                this.getData(path, (Consumer)this._actions.get(path));
            } catch (InterruptedException | KeeperException var5) {
                this.logException(var5);
                this.startRepair();
            }
        }

    }

    public void add(String path, Consumer<List<String>> serviceListChangedAction) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(path, "path");
        Guard.ThrowIfArgumentIsNull(serviceListChangedAction, "serviceListChangedAction");
        if (this._actions.containsKey(path)) {
            throw new Exception(String.format("您的配置文件中存在重复的Rpc路径，路径为:%s", path));
        } else {
            this._actions.put(path, serviceListChangedAction);

            try {
                if (this._zooKeeper != null && this._zooKeeper.getState().equals(ZooKeeper.States.CONNECTED)) {
                    this.getData(path, serviceListChangedAction);
                }
            } catch (InterruptedException | KeeperException var4) {
                this.logException(var4);
                this.startRepair();
            }

        }
    }

    void tryRepair(Object obj) throws InterruptedException {
        log.info("RPC服务中心{}断开连接，尝试连接", this._respository);

        while(true) {
            try {
                this.repairProcess();
                break;
            } catch (Exception var3) {
                this.close();
                Thread.sleep(120L);
            }
        }

        log.info("已与RPC服务中心{}建立连接", this._respository);
    }

    private void getData(String path, Consumer<List<String>> action) throws KeeperException, InterruptedException {
        List<String> result = this._zooKeeper.getChildren(path, this);
        String[] array = result != null ? (String[])result.toArray(new String[result.size()]) : new String[0];
        String ipList = String.join(",", array);
        log.info("RPC路径{}发现有新的服务器列表,服务器列表为：{}", path, ipList);
        if (array.length != 0) {
            action.accept(result);
        }

    }

    private void close() {
        if (this._zooKeeper != null) {
            try {
                this._zooKeeper.close();
                this._zooKeeper = null;
            } catch (Exception var2) {
                ;
            }

        }
    }

    private void repairProcess() throws Exception {
        if (this._zooKeeper != null && !this._zooKeeper.getState().isAlive()) {
            this.close();
        }

        try {
            if (this._zooKeeper == null) {
                this.create();
            }

            this.getDataList();
        } catch (Exception var3) {
            String log = this.logException(var3);
            throw new Exception(log);
        }
    }

    private void getDataList() throws KeeperException, InterruptedException {
        Iterator var1 = this._actions.entrySet().iterator();

        while(var1.hasNext()) {
            Map.Entry<String, Consumer<List<String>>> entry = (Map.Entry)var1.next();
            this.getData((String)entry.getKey(), (Consumer)entry.getValue());
        }

    }
}
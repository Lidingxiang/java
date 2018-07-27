package com.dingxiang.servicecentre;

import com.dingxiang.Guard;
import com.dingxiang.RandomUtil;
import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FinderImplZk implements Finder, Watcher {

    private static final Logger log = Logger.getLogger(FinderImplZk.class);

    private static final int repairInterval = 2 * 60;
    private static final int timeout = 1000 * 50;
    private final ConcurrentHashMap<String, Consumer<List<String>>> _actions = new ConcurrentHashMap<>();

    private ZooKeeper _zooKeeper;
    private String _respository;

    @Override
    public void init(String respository) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(respository, "respository");
        this._respository = respository;
        try {
            if (this._zooKeeper == null) {
                this.create();
            }
        } catch (Exception ex) {
            logException(ex);
            startRepair();
        }
    }

    private void create() throws Exception {
        String[] array = this._respository.split(",");
        int radomNum = RandomUtil.GetRandomNext(array.length);
        String address = array[radomNum];
        this._zooKeeper = new ZooKeeper(address, timeout, this);
        int num = 10;
        ZooKeeper.States states = _zooKeeper.getState();
        while (!states.equals(ZooKeeper.States.NOT_CONNECTED) && num-- > 1) {
            Thread.sleep(1000);
        }
        if (!this._zooKeeper.getState().equals(ZooKeeper.States.CONNECTED)) {
            throw new Exception(String.format("连接服务中心时发生超时，zookeeper地址为:%s", _respository));
        }
    }

    private String logException(Exception ex) {
        String text;
        if (ex instanceof KeeperException.ConnectionLossException) {
            text = String.format("无法连接到服务中心，zookeeper地址为:%s", _respository);
        } else if (ex instanceof KeeperException.SessionExpiredException) {
            text = String.format("连接服务中心时发生超时，zookeeper地址为:%s", _respository);
        } else {
            text = String.format("zookeeper获取节点数据出现异常，zookeeper地址为:%s ", this._respository);
        }
        log.info(text);
        return text;
    }

    private void startRepair() {

    }

    @Override
    public void add(String path, Consumer<List<String>> serviceListChangedAction) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(path, "path");
        Guard.ThrowIfArgumentIsNull(serviceListChangedAction, "serviceListChangedAction");
        if (this._actions.containsKey(path)) {
            throw new Exception(String.format("您的配置文件中存在重复的Rpc路径，路径为:%s", path));
        }
        _actions.put(path, serviceListChangedAction);
        try {
            if (this._zooKeeper != null && this._zooKeeper.getState().equals(ZooKeeper.States.CONNECTED)) {
                this.getData(path, serviceListChangedAction);
            }
        } catch (KeeperException | InterruptedException ex) {
            logException(ex);
            startRepair();
        }
    }

    private void getData(String path, Consumer<List<String>> action) throws KeeperException, InterruptedException {
        List<String> result = _zooKeeper.getChildren(path, this);
        String[] array = result != null ? result.toArray(new String[result.size()]) : new String[0];
        String ipList = String.join(",", array);
        log.info(String.format("RPC路径%s发现有新的服务器列表,服务器列表为：%s", path, ipList));
        if (array.length != 0) {
            action.accept(result);
        }
    }

    @Override
    public void process(WatchedEvent event) {
        String logText = String.format("ZooKeeper 状态发生更改 RPC路径：%s 服务中心地址：%s event.type:%s event.state%s",
                event.getPath(), _respository, event.getType(), event.getState());
        log.info(logText);
        Event.KeeperState state = event.getState();
        if (state != Event.KeeperState.Expired) {
            String path = event.getPath();
            try {
                if (path == null || path.isEmpty()) {
                    return;
                }
                this.getData(path, _actions.get(path));
            } catch (KeeperException | InterruptedException ex) {
                logException(ex);
                startRepair();
            }
        }
    }
}

package cicada.thrift.zookeeper;


import cicada.core.RandomUtil;
import java.io.IOException;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException.ConnectionLossException;
import org.apache.zookeeper.KeeperException.SessionExpiredException;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ServicePublisherImpl implements ServicePublisher, Watcher, DisposableBean {
    private static final Logger log = LoggerFactory.getLogger(ServicePublisherImpl.class);
    private static final int repairInterval = 10000;
    private static final int timeout = 10000;
    private ZooKeeper _zooKeeper;
    private String _respository;
    private ConnectionFailProcessMode _mode;
    private String _path;
    private String _dataPath;
    private boolean _running;

    public ServicePublisherImpl() {
    }

    public void Init(String respository, ConnectionFailProcessMode mode, String path, String data) {
        this._respository = respository;
        this._mode = mode;
        if (path != null && !path.isEmpty() && path.substring(0, 1).equals("/")) {
            this._path = path;
        } else {
            this._path = "/" + path;
        }

        this._dataPath = this._path.concat("/").concat(data);
    }

    public void publish() {
        this._running = true;
        this.StartRepair();
    }

    public void cancel() {
        this._running = false;
    }

    public void process(WatchedEvent event) {
        if (log.isInfoEnabled()) {
            log.info(String.format("ZooKeeper 状态发生更改 服务中心地址：%s event.type:%s event.state:%s", this._respository, event.getType(), event.getState()));
        }

        KeeperState state = event.getState();
        if (state != KeeperState.Expired) {
            switch(state) {
                case Unknown:
                case Disconnected:
                case NoSyncConnected:
                    break;
                default:
                    try {
                        this.validateExistPath();
                    } catch (Exception var4) {
                        this.logException(var4);
                        this.failProcess();
                    }

                    return;
            }
        }

    }

    private void StartRepair() {
        ServicePublisherImpl.RepairThread repair = new ServicePublisherImpl.RepairThread();
        Thread thread = new Thread(repair);
        thread.start();
    }

    void tryRepair(Object obj) throws InterruptedException {
        log.info(String.format("RPC服务中心%s断开连接，尝试连接", this._respository));
        int count = 0;

        while(this._running) {
            if (count > 10) {
                log.info(String.format("不能与RPC服务中心%s链接成功，系统将停止自动尝试!", this._respository));
                break;
            }

            try {
                this.repairProcess();
                log.info(String.format("已与RPC服务中心%s建立连接", this._respository));
                break;
            } catch (Exception var4) {
                this.close();
                Thread.sleep(10000L);
                log.error(String.format("RPC 建立链接出错:%s,详细信息:%s", var4.getMessage(), var4.getStackTrace()));
                ++count;
            }
        }

    }

    private void failProcess() {
        ConnectionFailProcessMode mode = this._mode;
        if (mode == ConnectionFailProcessMode.Retry) {
            this.StartRepair();
        } else if (mode == ConnectionFailProcessMode.Throw) {
            log.error(String.format("与服务中心%s断开连接", this._respository));
        }
    }

    private void repairProcess() throws Exception {
        if (this._zooKeeper != null && !this._zooKeeper.getState().isAlive()) {
            this.close();
            Thread.sleep(120000L);
        }

        try {
            if (this._zooKeeper == null) {
                this.create();
            }

            this.delExistsNode();
            ZKPaths.mkdirs(this._zooKeeper, this._path);
            this._zooKeeper.create(this._dataPath, new byte[0], Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            this.validateExistPath();
        } catch (Exception var2) {
            throw var2;
        }
    }

    private void validateExistPath() throws KeeperException, InterruptedException, Exception {
        if (this._zooKeeper == null || this._zooKeeper.exists(this._dataPath, this) == null) {
            throw new Exception("节点不存在");
        }
    }

    private String logException(Exception ex) {
        String text;
        if (ex instanceof ConnectionLossException) {
            text = String.format("无法连接到服务中心，地址为:%s", this._respository);
        } else if (ex instanceof SessionExpiredException) {
            text = String.format("连接服务中心时发生超时，地址为:%s", this._respository);
        } else {
            text = String.format("RPC zookeeper注册节点时出现异常，地址为:%s", this._respository);
        }

        log.error(text);
        return text;
    }

    private void create() throws InterruptedException, IOException {
        String[] array = this._respository.split(",");
        String connectString = array[RandomUtil.GetRandomNext(array.length)];
        this._zooKeeper = new ZooKeeper(connectString, 10000, this);
        int var3 = 10;

        while(!this._zooKeeper.getState().equals(States.CONNECTED) && var3-- > 1) {
            Thread.sleep(1000L);
        }

    }

    private void close() {
        if (this._zooKeeper != null) {
            try {
                this._zooKeeper.close();
                this._zooKeeper = null;
            } catch (Exception var3) {
                String mString = String.format("关闭zookerper服务出错:%s", var3.getMessage());
                log.error(mString, var3);
            }

        }
    }

    private void delExistsNode() throws KeeperException, InterruptedException {
        Stat stat = this._zooKeeper.exists(this._dataPath, this);
        if (stat != null) {
            this._zooKeeper.delete(this._dataPath, stat.getAversion());
        }

    }

    public void destroy() throws Exception {
        this.close();
    }

    public class RepairThread implements Runnable {
        public RepairThread() {
        }

        public void run() {
            try {
                ServicePublisherImpl.this.tryRepair(new Object());
            } catch (InterruptedException var3) {
                String mString = String.format("修复zookeeper出错,%s", var3.getMessage());
                ServicePublisherImpl.log.error(mString, var3);
            }

        }
    }
}

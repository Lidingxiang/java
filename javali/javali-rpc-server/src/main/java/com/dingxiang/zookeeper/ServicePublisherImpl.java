package com.dingxiang.zookeeper;

import com.dingxiang.RandomUtil;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Scope("prototype")
public class ServicePublisherImpl implements ServicePublisher, Watcher, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(ServicePublisherImpl.class);
    private static final int timeout = 1000 * 10;
    private static final int repairInterval = 1000 * 10;

    private String _respository;
    private ConnectionFailProcessMode _mode;
    private ZooKeeper _zooKeeper;
    private String _path;
    private String _dataPath;
    private boolean _running;

    @Override
    public void Init(String respository, ConnectionFailProcessMode mode, String path, String data) {
        this._respository = respository;
        this._mode = mode;
        if (path == null || path.isEmpty() || !path.substring(0, 1).equals("/")) {
            this._path = "/" + path;
        } else {
            this._path = path;
        }
        this._dataPath = this._path.concat("/").concat(data);
    }

    @Override
    public void publish() {
        this._running = true;
        this.StartRepair();
    }

    private void StartRepair() {
        RepairThread repair = new RepairThread();
        Thread thread = new Thread(repair);
        thread.setDaemon(true);
        thread.start();
    }

    public class RepairThread implements Runnable {
        public void run() {
            try {
                tryRepair();
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    void tryRepair() throws InterruptedException {
        logger.info(String.format("RPC服务中心%s断开连接，尝试连接", this._respository));
        int count = 0;
        while (this._running) {
            if (count > 10) {
                logger.info(String.format("不能与RPC服务中心%s链接成功，系统将停止自动尝试!", this._respository));
                break;
            }
            try {
                this.repairProcess();
                logger.info(String.format("已与RPC服务中心%s建立连接", this._respository));
                break;
            } catch (Exception ex) {
                this.close();
                Thread.sleep(repairInterval);
                logger.error(String.format("RPC 建立链接出错:%s,详细信息:%s", ex.getMessage(), ex.getStackTrace()));
            }
            count++;
        }
    }

    private void repairProcess() throws Exception {
        if (this._zooKeeper != null && !this._zooKeeper.getState().isAlive()) {
            this.close();
            Thread.sleep(120 * 1000);
        }
        try {
            if (this._zooKeeper == null) {
                this.create();
            }

            ZKPaths.mkdirs(this._zooKeeper, this._path);
            this._zooKeeper.create(this._dataPath, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            this.validateExistPath();
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void validateExistPath() throws Exception {
        if (this._zooKeeper == null || this._zooKeeper.exists(this._dataPath, this) == null) {
            throw new Exception("节点不存在");
        }
    }

    private void create() throws InterruptedException, IOException {
        String[] array = this._respository.split(",");
        String connectString = array[RandomUtil.GetRandomNext(array.length)];
        this._zooKeeper = new ZooKeeper(connectString, timeout, watchedEvent -> {
        });
        int num = 10;
        while (!this._zooKeeper.getState().equals(ZooKeeper.States.CONNECTED) && num-- > 1) {
            Thread.sleep(1000);
        }
    }

    private void close() {
        if (this._zooKeeper == null) {
            return;
        }
        try {
            this._zooKeeper.close();
            this._zooKeeper = null;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }


    @Override
    public void cancel() {
        this._running = false;
    }

    @Override
    public void destroy() throws Exception {
        this.cancel();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void process(WatchedEvent event) {
        if (logger.isInfoEnabled()) {
            logger.info(String.format("ZooKeeper 状态发生更改 服务中心地址：%s event.type:%s event.state:%s",
                    this._respository, event.getType(), event.getState()));
        }
        Watcher.Event.KeeperState state = event.getState();
        if (state != Watcher.Event.KeeperState.Expired) {
            switch (state) {
                case Unknown:
                    break;
                case Disconnected:
                    break;
                case NoSyncConnected:
                    break;
                default:
                    try {
                        this.validateExistPath();
                    } catch (Exception ex) {
                        logException(ex);
                        this.failProcess();
                    }
                    return;
            }
        }
        this.failProcess();
    }

    private void failProcess() {
        ConnectionFailProcessMode mode = this._mode;
        if (mode == ConnectionFailProcessMode.Retry) {
            this.StartRepair();
            return;
        }
        if (mode != ConnectionFailProcessMode.Throw) {
            return;
        }
        logger.error(String.format("与服务中心%s断开连接", this._respository));
    }

    private String logException(Exception ex) {
        String text;
        if (ex instanceof KeeperException.ConnectionLossException) {
            text = String.format("无法连接到服务中心，地址为:%s", this._respository);
        } else if (ex instanceof KeeperException.SessionExpiredException) {
            text = String.format("连接服务中心时发生超时，地址为:%s", this._respository);
        } else {
            text = String.format("RPC zookeeper注册节点时出现异常，地址为:%s", this._respository);
        }
        logger.error(text);
        return text;
    }
}

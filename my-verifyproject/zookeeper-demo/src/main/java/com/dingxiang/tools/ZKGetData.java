package com.dingxiang.tools;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.UnsupportedEncodingException;

public class ZKGetData {

    public static String getData(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException, UnsupportedEncodingException {
        Stat stat = ZKExists.znode_exists(zooKeeper, path);
        if (stat != null) {

//            final CountDownLatch connectedSignal = new CountDownLatch(1);

            byte[] ret = zooKeeper.getData(path, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("===>ZKGetData--->getType:" + watchedEvent.getType() + ";getState:" + watchedEvent.getState());
                    if (watchedEvent.getType() == Event.EventType.None) {
                        switch (watchedEvent.getState()) {
                            case Expired:
//                                connectedSignal.countDown();
                                break;
                        }
                    }else{
//                        connectedSignal.countDown();
                    }
                }
            }, stat);

            String data = new String(ret, "UTF-8");
//            connectedSignal.await();
            return data;
        }
        return "";
    }


}

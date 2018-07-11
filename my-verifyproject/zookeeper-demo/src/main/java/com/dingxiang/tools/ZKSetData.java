package com.dingxiang.tools;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZKSetData {

    public static void update(ZooKeeper zooKeeper,String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.setData(path, data, zooKeeper.exists(path, true).getVersion());
    }
}

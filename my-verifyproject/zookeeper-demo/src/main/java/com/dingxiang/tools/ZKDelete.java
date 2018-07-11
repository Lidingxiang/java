package com.dingxiang.tools;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZKDelete {

    public static void delete(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        zooKeeper.delete(path, -1);
    }
}

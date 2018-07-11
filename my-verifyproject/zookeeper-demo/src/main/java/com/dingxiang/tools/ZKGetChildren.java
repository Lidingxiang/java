package com.dingxiang.tools;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

public class ZKGetChildren {

    public static List<String> getChildren(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        boolean exists = ZKExists.znode_exist(zooKeeper, path);
        if (!exists) return null;
        return zooKeeper.getChildren(path, false);
    }
}

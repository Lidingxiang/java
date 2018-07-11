package com.dingxiang.tools;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZKCreate {

    /*
    * 创建持久化目录节点
    * */
    public static void createPersistentPath(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {

        int pos = 1;
        do {
            pos = path.indexOf('/', pos + 1);

            if (pos == -1) {
                pos = path.length();
            }
            String subPath = path.substring(0, pos);
            if (zooKeeper.exists(subPath, false) == null) {
                try {
                    zooKeeper.create(subPath, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                } catch (KeeperException.NodeExistsException e) {
                    // ignore... someone else has created it since we checked
                }
            }
        }
        while (pos < path.length());
    }

    /*
    * 创建持久化目录节点
    * */
    public static void createEphemeral(ZooKeeper zooKeeper, String dataPath) throws KeeperException, InterruptedException {
        zooKeeper.create(dataPath, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
    }

    /*
    * 创建排序节点
    * */
    public static void createEphemeral_Sequential(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        zooKeeper.create(path + "/client", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
    }
}

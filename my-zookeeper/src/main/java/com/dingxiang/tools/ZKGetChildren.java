package com.dingxiang.tools;

import org.apache.log4j.BasicConfigurator;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class ZKGetChildren {
    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;
    private static String zkServerAddress = "172.18.115.15";

    // Method to check existence of znode and its status, if znode is available.
    public static Stat znode_exists(String path) throws KeeperException, InterruptedException {
        return zk.exists(path, true);
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        String path = "/Rpc/JavaCi"; // Assign path to the znode

        BasicConfigurator.configure();
        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect(zkServerAddress);
            Stat stat = znode_exists(path); // Stat checks the path

            if (stat != null) {

                //“getChildren" method- get all the children of znode.It has two args, path and watch
                List<String> children = zk.getChildren(path, false);
                if (children.isEmpty())
                    System.out.println("children的Size为" + String.valueOf(children.size()));
                for (int i = 0; i < children.size(); i++)
                    System.out.println(children.get(i)); //Print children's
            } else {
                System.out.println("Node does not exists");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
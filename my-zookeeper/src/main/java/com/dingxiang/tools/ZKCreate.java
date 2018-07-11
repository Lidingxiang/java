package com.dingxiang.tools;

import org.apache.log4j.BasicConfigurator;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZKCreate {

    // create static instance for zookeeper class.
    private static ZooKeeper zk;

    // create static instance for ZooKeeperConnection class.
    private static ZooKeeperConnection conn;

    private static String zkServerAddress = "172.18.115.15";

    // Method to create znode in zookeeper ensemble
    public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
    }

    public static void main(String[] args) {

        BasicConfigurator.configure();
        System.out.println("==================begin===============");

        // znode path
//        String path = "/MyFirstZnode"; // Assign path to znode
//        byte[] data = "My first zookeeper app01".getBytes(); // Declare data


        // data in byte array
        byte[] data = new byte[0];
        String path = "/MyFirstZnode/172.18.115.15:6379"; // Assign path to znode

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect(zkServerAddress);
            create(path, data); // Create the data to the specified path
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage()); //Catch error message
        }
    }
}
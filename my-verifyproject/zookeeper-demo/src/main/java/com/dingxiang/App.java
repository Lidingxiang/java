package com.dingxiang;

import com.dingxiang.tools.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static ZooKeeperConnection conn;
    private static String zkServerAddress = "172.18.115.15";
    private static ZooKeeper zk;

    public static void main(String[] args) {

        BasicConfigurator.configure();
        System.out.println("==========创建持久化目录节点==========");

        String persistentPath = "/MyFirstZnode";
        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect(zkServerAddress);

            //创建持久化目录节点
            ZKCreate.createPersistentPath(zk, persistentPath);

            //创建临时目录节点
            /*String dataPath = persistentPath + "/" + "172.18.115.15:8000";
            ZKCreate.createEphemeral(zk, dataPath);*/

            //创建排序节点
            ZKCreate.createEphemeral_Sequential(zk,persistentPath);

            //判断节点是否存在
            Stat stat = ZKExists.znode_exists(zk, persistentPath);
            if (stat != null)
                System.out.println("===>Node exists and the node version is " + stat.getVersion());
            else
                System.out.println("===>Node does not exists");

            //获取成员数据
            List<String> children = ZKGetChildren.getChildren(zk, persistentPath);
            if (!children.isEmpty())
                System.out.println("====>children子节点数据：" + String.join(",", children));

            //更新存储数据
            ZKSetData.update(zk, persistentPath, "hello world1".getBytes());

            //获取节点数据
            String retData = ZKGetData.getData(zk, persistentPath);
            System.out.println("===>retData数据为:" + retData);

            //删除节点
//            ZKDelete.delete(zk, persistentPath);


//            conn.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

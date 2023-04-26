package com.miujoke;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.ZooDefs.Ids;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: miujoke
 * @DateTime: 2023/4/25 19:00
 */
public class ZKConfigGet {
    private static String connectString = "192.168.44.128:2181";
    private static int sessionTimeout = 50 * 1000;
    /**
     * 连接Zookeeper服务器
     * @return
     * @throws IOException
     */
    public ZooKeeper connectionZooKeeper() throws IOException {

        ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

            public void process(WatchedEvent event) {
                //可做其他操作（设置监听或观察者）
            }
        });
        return zooKeeper;
    }

    /**
     * 创建节点
     * 1. CreateMode.PERSISTENT ：持久节点，一旦创建就保存到硬盘上面
     　　　  2.  CreateMode.SEQUENTIAL ： 顺序持久节点
     　　　  3.  CreateMode.EPHEMERAL ：临时节点，创建以后如果断开连接则该节点自动删除
     　　　  4.  CreateMode.EPHEMERAL_SEQUENTIAL ：顺序临时节点
     * @param zooKeeper Zookeeper已经建立连接的对象
     * @param path 要创建节点的路径
     * @param data 该节点上的数据
     * @return 返回创建的节点的路径
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String createZKNode(ZooKeeper zooKeeper, String path, String data) throws KeeperException, InterruptedException {
        byte[] bytesData = data.getBytes();
        //访问控制列表
        ArrayList<ACL> openAclUnsafe = Ids.OPEN_ACL_UNSAFE;
        //创建模式
        CreateMode mode = CreateMode.PERSISTENT;
        String result = zooKeeper.create(path, bytesData, openAclUnsafe, mode);
        System.out.println("创建节点成功: " + result);
        return result;
    }

    /**
     * 获取节点上的数据
     * @param zooKeeper Zookeeper已经建立连接的对象
     * @param path 节点路径
     * @return 返回节点上的数据
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String getZKNodeData(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData(path, false, new Stat());
//        System.out.println("该节点" + path + "上的数据伟: " + new String(data));
        return new String(data);
    }

    /**
     * 设置节点上的数据
     * @param zooKeeper Zookeeper已经建立连接的对象
     * @param path 节点路径
     * @param data
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Stat setZKNodeData(ZooKeeper zooKeeper, String path, String data) throws KeeperException, InterruptedException {
        return zooKeeper.setData(path, data.getBytes(), -1);
    }

    /**
     * 判断节点是否存在
     * @param zooKeeper
     * @param path 节点路径
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Stat isExitZKPath(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists(path, false);
        return stat;
    }
}

package com.hy.think.distributed;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/7/2 16:30
 */
public class ZookeeperBase {

    static final String zkroot = "/zkroot";

    static final String rootdata = "zookeeper root";

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 10000, event -> {
            System.out.println(event.getType());
        });

        String path = zk.create(zkroot, rootdata.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println("the actual path is " + path);
        Stat stat = zk.exists(zkroot, true);
        System.out.println(stat.getVersion());
        zk.delete(path, stat.getVersion());
        zk.close();
    }


}

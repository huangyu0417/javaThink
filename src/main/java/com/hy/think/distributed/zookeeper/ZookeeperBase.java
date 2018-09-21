package com.hy.think.distributed.zookeeper;

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
        ZooKeeper zk = new ZooKeeper("localhost:2181", 10000, event -> System.out.println(event.getType()));

        Stat s = null;
        if ((s = zk.exists(zkroot, false)) == null) {
            System.out.println("not exists node => " + zkroot);
        } else {
            System.out.println("exists node => " + zkroot);
            zk.delete(zkroot, s.getVersion());
        }

        String path = zk.create(zkroot, rootdata.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("the actual path is " + path);
        Stat stat = zk.exists(zkroot, event -> System.out.println("exists watch => " + event.getType()));
        System.out.println(stat.getVersion());
        zk.close();

        ZooKeeper zk1 = new ZooKeeper("localhost:2181", 10000, event -> System.out.println(event.getType()));
        if (zk1.exists(zkroot, false) == null) {
            System.out.println("not exists node => " + zkroot);
        } else {
            System.out.println("exists node => " + zkroot);
        }
    }


}

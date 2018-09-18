package com.hy.think.distributed;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * desc: zookeeper工具类
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/9/17 17:16
 */
abstract class ZookeeperUtils {

    private static final byte defaultDate[] = {1};

    public static ZooKeeper getDefault() {
        ZooKeeper zooKeeper = null;
        CountDownLatch latch = new CountDownLatch(1);
        try {
            zooKeeper = new ZooKeeper("localhost:2181", 1000, event -> {
                System.out.println("Receive event" + event);
                if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                    System.out.println("connect is established");
                    latch.countDown();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }


    public static void createIfNotExist(ZooKeeper zooKeeper, String nodeName) {
        try {
            Stat stat = zooKeeper.exists(nodeName, false);
            if (stat == null) {
                zooKeeper.create(nodeName, defaultDate, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.hy.think.distributed;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * desc: 模拟服务器
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/9/17 17:26
 */
public class SimulationServer {

    private volatile boolean isMaster;

    static final String root = "/masterchoice";

    private ZooKeeper zooKeeper = ZookeeperUtils.getDefault();


    private byte[] host = getLocalHostIPAddress().getBytes();


    private String node;

    /**
     * 锁
     */
    private final Object mutex = new Object();



    public static void main(String[] args) throws InterruptedException {
        SimulationServer simulationServer = new SimulationServer();
        simulationServer.registMaster();
        simulationServer.start();
        TimeUnit.SECONDS.sleep(30);
    }

    public void start() {
        while (true) {
            synchronized (mutex) {
                try {
                    List<String> children = zooKeeper.getChildren(root, false);
                    SortedSet<String> sortedNode = children.stream().map(s -> root + '/' + s).collect(Collectors.toCollection(TreeSet::new));
                    System.out.println(sortedNode);
                    String first = sortedNode.first();
                    byte[] data = zooKeeper.getData(first, event -> {
                        if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
                            synchronized (mutex) {
                                mutex.notifyAll();
                            }
                        }
                    }, new Stat());
                    System.out.println("master is " + new String(data));
                    if (isMaster = Objects.equals(first, node)) {
                        System.out.println("yyy");
                        return;
                    } else {
                        System.out.println("xxx");
                        mutex.wait();
                    }

                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void registMaster() {
        ZookeeperUtils.createIfNotExist(zooKeeper, root);
        ensureLocalNodeExists();
    }



    public void ensureLocalNodeExists() {
        try {
            List<String> children = zooKeeper.getChildren(root, false);
            int size = children.size();
            for (int i = 0; i < size; i++) {
                String node = children.get(i);
                String path = root + '/' + node;
                Stat stat = new Stat();
                byte[] data = zooKeeper.getData(path, false, stat);
                if (Arrays.equals(data, host)) {
                    node = path;
                    return;
                }
            }
            node = zooKeeper.create(root + '/', host, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(node);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getLocalHostIPAddress() {
        Enumeration<NetworkInterface> networkInterfaces = null;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            return "127.0.0.1";
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();

            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress address = inetAddresses.nextElement();
                String hostAddress = address.getHostAddress();
                if (address instanceof Inet4Address && !"127.0.0.1".equals(hostAddress)){
                    return hostAddress + UUID.randomUUID();
                }
            }
        }
        return "127.0.0.1";
    }


    public boolean isMaster() {
        return isMaster;
    }
}

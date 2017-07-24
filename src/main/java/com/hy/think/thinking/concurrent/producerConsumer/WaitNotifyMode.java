package com.hy.think.thinking.concurrent.producerConsumer;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc:使用Object的wait(),notify()方法实现的生产者消费者
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/7/24 13:56
 */
public class WaitNotifyMode {
    private static final int MAX_SIZE = 20;
    private final Object monitor = new Object();
    private LinkedList<Product> queue = new LinkedList<Product>();

    public Producer getProducer() {
        return new Producer();
    }

    public Consumer getConsumer() {
        return new Consumer();
    }

    /**
     * 生产者
     */
    class Producer implements Runnable {
        @Override
        public void run() {
            for (; ; ) {
                synchronized (monitor) {
                    if (queue.size() >= MAX_SIZE) {
                        try {
                            System.out.println("产品已满，等待消费者消费...");
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Product product = new Product(queue.size() + 1);
                    queue.addLast(product);//生产
                    System.out.println("生产者生产：" + product);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    monitor.notifyAll();
                }
            }
        }
    }

    //消费者
    class Consumer implements Runnable {
        @Override
        public void run() {
            for (; ; ) {
                synchronized (monitor) {
                    if (queue.size() == 0) {
                        try {
                            System.out.println("暂无产品，等待生产者生产...");
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Product product = queue.pollFirst();
                    System.out.println("消费者消费：" + product);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    monitor.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        WaitNotifyMode procedure = new WaitNotifyMode();
        threadPool.execute(procedure.getConsumer());
        threadPool.execute(procedure.getProducer());
        threadPool.shutdown();
    }
}

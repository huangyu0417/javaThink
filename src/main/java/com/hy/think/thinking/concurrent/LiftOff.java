package com.hy.think.thinking.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc:模拟火箭发射倒计时任务
 * @author hy
 * @version 1.0
 * @Created on 2017/7/11 8:44
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private volatile static int taskCount = 0;
    private final int id = taskCount++;

    @Override
    public void run() {
        while (countDown-- > 0) {
            synchronized (LiftOff.class){//用this不能保证同步，因为每次都是new了一个LifftOff
                System.out.print(status());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
            Thread.yield();
        }
    }

    private String status() {
        StringBuilder builder = new StringBuilder();
        builder.append("#").append(id)
                .append("(")
                .append(countDown>0?countDown:"LiftOff")
                .append("), ");
        return builder.toString();
    }

    public static void main(String[] args){
        new Thread(new LiftOff()).start();
        new Thread(new LiftOff()).start();
        new Thread(new LiftOff()).start();

        //线程池

        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(new LiftOff());
        threadPool.execute(new LiftOff());
    }
}

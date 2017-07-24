package com.hy.think.thinking.concurrent;

/**
 * description:
 * author: huangyu
 * create on 17-7-24 下午11:29
 */
public class PrintTask implements Runnable{
    @Override
    public void run() {
        while (true) {
//            synchronized (PrintTask.class) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }
    }

    public static void main(String[] args){
        PrintTask t1 = new PrintTask();
        PrintTask t2 = new PrintTask();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.setName("====thread1");
        thread1.start();
        thread2.setName("thread2----");
        thread2.start();
    }
}

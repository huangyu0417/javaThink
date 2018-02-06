package com.hy.think.thinking.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc:
 * @author hy
 * @version 1.0
 * @Created on 2018/1/26 16:10
 */
public class ThreadLocalEg {

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


    private static ThreadLocal<DateFormat> formatCurrentThread = ThreadLocal.withInitial(() -> {
        SimpleDateFormat instance = (SimpleDateFormat) DateFormat.getInstance();
        instance.applyPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return instance;
    });


    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(9);

//        for (int i = 0; i < 20000; i++) {
//            threadPool.submit(() -> System.out.println(Thread.currentThread().getName() + "   =>   " +format.format(new Date())));
//        }


        for (int i = 0; i < 20000; i++) {
            threadPool.submit(() -> System.out.println(Thread.currentThread().getName() + "   =>   " +formatCurrentThread.get().format(new Date())));
        }

    }
}

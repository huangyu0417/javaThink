package com.hy.think.thinking.concurrent.futureTaskThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/9/21 16:16
 */
public class RunCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<Integer> f1 =  threadPool.submit(new Calculator(4,6));
        System.out.println(f1.get());
    }
}

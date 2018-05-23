package com.hy.think;

import com.google.common.collect.Sets;

import java.text.DateFormat;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/4/26 8:55
 */
public class Notes {



    private static CountDownLatch countDownLatch = null;

    public static void main(String[] args) {
        atomicIntegerT();

    }

    static void atomicIntegerT() {
        AtomicIntegerThreadSafe atomicIntegerThreadSafe = new AtomicIntegerThreadSafe();
        atomicIntegerThreadSafe.multThreadAtomicIntegerSafe(40);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicIntegerThreadSafe.result();
    }

    static class AtomicIntegerThreadSafe {
        private AtomicInteger atomicInteger = new AtomicInteger();

        public AtomicIntegerThreadSafe() {
        }

         void multThreadAtomicIntegerSafe(int threadCount) {
            countDownLatch = new CountDownLatch(threadCount);
            ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
            for (int i = 0; i < threadCount; i++) {
                executorService.submit(() -> {
                    for (int j = 0; j < 100000; j++) {
                        increase();
                    }
                    countDownLatch.countDown();
                });
            }
            executorService.shutdown();
        }

         void increase() {
            atomicInteger.incrementAndGet();
        }

        void result() {
            System.out.println(atomicInteger.intValue());
        }
    }

    public Inner inner() {
        return new Inner();
    }

    private class Inner {

    }

}

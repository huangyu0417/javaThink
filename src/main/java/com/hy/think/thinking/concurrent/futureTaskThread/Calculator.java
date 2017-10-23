package com.hy.think.thinking.concurrent.futureTaskThread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/9/21 16:11
 */
public class Calculator implements Callable<Integer> {
    private int a;
    private int b;
    public Calculator(int a,int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        return a + b;
    }
}

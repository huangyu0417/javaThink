package com.hy.think.thinking.classInfo;

import java.lang.reflect.Proxy;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/17 17:42
 */
public class StringTask implements RunTask {

    @Override
    public void run() {
        String a = "";

        for (int i = 0; i < 1000; i++ ) {
            a += i;
        }

    }

    public static void main(String[] args){
        RunTask task = (RunTask) Proxy.newProxyInstance(StringTask.class.getClassLoader(),new Class[]{RunTask.class},new RunTaskProxy());
        task.run();
    }
}

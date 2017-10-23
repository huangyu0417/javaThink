package com.hy.think.thinking.classInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/17 17:36
 */
public class RunTaskProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long begin = System.currentTimeMillis();
        System.out.println("开始运行" + method.getClass().getSimpleName() + "类的" + method.getName() + "方法");
        Object object = method.invoke(proxy,args);
        System.out.println("运行结束，总共" + (System.currentTimeMillis() - begin) + "毫秒");
        return object;
    }
}

package com.hy.think.generics.genericsInterface;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/6/29 8:40
 */
public class Animal {
    private static long counter = 0;//计数器
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

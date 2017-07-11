package com.hy.think.thinking.generics.genericsInterface;

import java.util.Iterator;

/**
 * desc: 装饰器，通过继承把Fibonacci装饰成可迭代的
 * @author hy
 * @version 1.0
 * @Created on 2017/6/29 14:16
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n = 0;

    public IterableFibonacci() {}

    public IterableFibonacci(int count) {
        this.n = count;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n --;
                return IterableFibonacci.this.create();
            }
        };
    }

    public static void main(String[] args){
        IterableFibonacci iterableFibonacci = new IterableFibonacci(20);
        Iterator<Integer> iterator = iterableFibonacci.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}

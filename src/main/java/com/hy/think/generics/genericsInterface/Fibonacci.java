package com.hy.think.generics.genericsInterface;

/**
 * desc:斐波拉契数列生成器
 * @author hy
 * @version 1.0
 * @Created on 2017/6/29 14:02
 */
public class Fibonacci implements Generator<Integer>{
    private int count = 0;

    /**
     * description: 创建T
     * @return
     * @author hy
     * @version 1.0
     * @created 2017/6/29 8:39
     */
    @Override
    public Integer create() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci.create() + " ");
        }
    }

}

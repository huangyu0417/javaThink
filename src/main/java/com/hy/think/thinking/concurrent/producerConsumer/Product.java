package com.hy.think.thinking.concurrent.producerConsumer;

/**
 * desc: 产品
 * @author hy
 * @version 1.0
 * @Created on 2017/7/24 14:02
 */
public class Product {
    /**
     * 序号
     */
    private int id;

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product of "+id;
    }
}

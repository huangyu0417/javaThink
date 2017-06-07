package com.hy.think;

import java.util.Arrays;
import java.util.List;

/**
 * description:
 * author: huangyu
 * create on 17-6-6 下午11:03
 */
public class Lambda {
    public static void main(String[] args){
        List<String> list = Arrays .asList("world!","hello");
        list.sort((a,b)->a.compareTo(b));
        list.forEach(e->System.out.println(e));
    }
}

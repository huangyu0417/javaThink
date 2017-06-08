package com.hy.think.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/6/7 12:57
 */
public class StreamAPI {
    public static void main(String[] args){
//        List<String> list = Arrays.asList("lsjdl","ksiii","lsjdlk","sd","ki");
//        list.stream().filter(s -> s.length() < 3)
//                .forEach(s -> System.out.println(s));
        List<Double> list = new ArrayList<Double>();
        for(int i=0;i<1000000;i++){
            double d = Math.random() * 1000;
            list.add(d);
        }
        long start = System.nanoTime();
        list = list.stream().sequential().sorted().collect(Collectors.toList());
        long end = System.nanoTime();
        list = list.stream().parallel().sorted().collect(Collectors.toList());
        long parTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-end);//得到并行排序所用的时间
        long seqTime = TimeUnit.NANOSECONDS.toMillis(end-start);//得到串行排序所用的时间
        System.out.println("并行时间:"+parTime+";串行时间:"+seqTime);
    }
}

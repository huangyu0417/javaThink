package com.hy.think.thinking.operators;

import redis.clients.jedis.Jedis;

/**
 * description:
 * author: huangyu
 * create on 17-6-19 下午10:55
 */
public class Operator {
    public static void main(String[] args){
//        int i = 12;
//        int j = -4;
//        System.out.println(Integer.toBinaryString(i<<2));
//        System.out.println(Integer.toBinaryString(j));
//        System.out.println(Integer.toBinaryString(j<<2));
        Jedis jedis = new Jedis("192.168.146.128",6379);
        jedis.keys("*").forEach(System.out::println);
        System.out.println(jedis.get("lock"));
        jedis.close();

    }
}

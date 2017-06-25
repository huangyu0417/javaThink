package com.hy.think.thinking.objects;

import java.math.BigDecimal;

/**
 * description:
 * author: huangyu
 * create on 17-6-15 下午11:03
 */
public class BasicTypes {
    public static void main(String[] args){
        /**
         *
         */
        boolean flag = true;

        /**
         * byte 8 bits min -128 max +127
         */
        byte b = 36;

        /**
         * char 16 bits min Unicode o max (2^16)-1
         */
        char c = 'a';

        /**
         *  short 16 bits min -2^15 -32768 max (2^15)-1 32767
         */
        short s = 134;
        System.out.println("Short Max:" + Short.MAX_VALUE);
        System.out.println("Short Min:" + Short.MIN_VALUE);

        /**
         * int 32 bits min -2^31 -2147483648 max (2^32)-1 2147483647
         */
        int i = 8238;
        System.out.println("Integer Max" + Integer.MAX_VALUE);
        System.out.println("Integer Min" + Integer.MIN_VALUE);

        /**
         * long 64 bits min -2^63 max (2^64)-1
         */
        long l = 92839829823L;

        /**
         * float 32 bits
         */
        float f = 132.2838283F;

        System.out.println("Double Max:"+Double.MAX_VALUE);
        System.out.println("Double Min:"+Double.MIN_VALUE);
        /**
         * double 64 bits
         */
        double d = 848998349.238928;

        BigDecimal decimal = new BigDecimal("82.2323");

    }
}

package com.hy.think.java8;

import java.util.Optional;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/7/6 8:33
 */
public class OptionalUse {
    static final String DEF = "default String";
    public static void main(String[] args){
        String a = "hello";
        String b = null;
        System.out.println(toUpperCase(a));
        System.out.println(toUpperCase(b));
    }

    static String toUpperCase(String s) {
        Optional<String> key = Optional.ofNullable(s);
//        if (key.isPresent()) {
//            return key.get().toUpperCase();
//        } else {
//            return DEF.toUpperCase();
//        }
        return key.orElse(DEF).toUpperCase();
    }
}

package com.hy.think.java8;

import java.util.function.Function;

/**
 * desc:
 * @author hy
 * @version 1.0
 * @Created on 2017/7/26 8:39
 */
public class FunctionCombination {
    public static void main(String[] args){
        Function<Integer,Integer> f1 = e -> e<<2;
        Function<Integer,Integer> f2 = a -> a*a;
        System.out.println(f1.apply(4));

//        default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
//            Objects.requireNonNull(before);
//            return (V v) -> apply(before.apply(v));
//        }
        System.out.println(f1.compose(f2).apply(5));


//        default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
//            Objects.requireNonNull(after);
//            return (T t) -> after.apply(apply(t));
//        }
        System.out.println(f1.andThen(f2).apply(5));
    }
}

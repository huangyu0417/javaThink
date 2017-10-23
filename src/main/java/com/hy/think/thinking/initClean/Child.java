package com.hy.think.thinking.initClean;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/10/13 9:15
 */
public class Child extends Basis {
    public Child(String name) {
        super(name);
//        setName(name);
    }

    @Override
    public void setName(String name) {
        System.out.println("child====");
    }
    public static void main(String[] args){
        Child child= new Child("hhh");
        System.out.println(child.getName());
    }
}

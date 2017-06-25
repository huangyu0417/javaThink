package com.hy.think.thinking.initClean;

/**
 * description: 静态变量和静态块初始化顺序
 * author: huangyu
 * create on 17-6-25 下午11:20
 */
public class StaticInitOrder {
    static {
        System.out.println("static block");
    }
    public static void main(String[] args){
        Cups.cup1.f("This is the cup1");
        /*
        static block
        Cup(2)
        Cup(1)
        This is the cup1
        */
    }
}

class Cup {
    Cup(int maker) {
        System.out.println("Cup(" + maker + ")");
    }

    void f(String s) {
        System.out.println(s);
    }
}

class Cups {
    static {
        cup1 = new Cup(1);
    }
    static Cup cup1;
    static Cup cup2 = new Cup(2);
    Cups() {
        System.out.println("cups");
    }
}

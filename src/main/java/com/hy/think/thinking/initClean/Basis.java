package com.hy.think.thinking.initClean;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/10/13 9:13
 */
public class Basis {
    private String name;


    public Basis(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("basis====");
        this.name = name;
    }

}

package com.hy.think.spring.lifecycle;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/11/23 16:08
 */
public class User {
    private String name;

    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

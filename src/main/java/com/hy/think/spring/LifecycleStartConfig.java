package com.hy.think.spring;

import com.hy.think.spring.lifecycle.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * desc:spring生命周期启动配置文件
 * @author hy
 * @version 1.0
 * @Created on 2017/11/23 15:49
 */
@ComponentScan(basePackages = {"com.hy.think.spring.lifecycle"})
public class LifecycleStartConfig {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(LifecycleStartConfig.class);
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao.getUser());
    }
}

package com.hy.think.spring.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * desc:
 * @author hy
 * @version 1.0
 * @Created on 2017/11/23 15:45
 */
@Repository
public class UserDao implements BeanNameAware,BeanFactoryAware, InitializingBean,FactoryBean<UserDao>,ApplicationListener<ContextRefreshedEvent>{
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    private static final String className = UserDao.class.getSimpleName();

    public User getUser() {
        return new User("admin","123456");
    }

    @PostConstruct
    public void initMethod() {
        if (logger.isInfoEnabled()) {
            logger.info("{} init",className);
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (logger.isInfoEnabled()) {
            logger.info("setBeanFactory => {}",className);
        }
    }

    @Override
    public void setBeanName(String name) {
        if (logger.isInfoEnabled()) {
            logger.info("setBeanName => {}",className);
        }
    }

    @Nullable
    @Override
    public UserDao getObject() throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info("getObject => {}",className);
        }
        return new UserDao();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        if (logger.isInfoEnabled()) {
            logger.info("getObjectType => {}",className);
        }
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        if (logger.isInfoEnabled()) {
            logger.info("isSingleton => {}",className);
        }
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info("afterPropertiesSet => {}",className);
        }
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (logger.isInfoEnabled()) {
            logger.info("onApplicationEvent => {}",className);
        }
    }
}

package com.hy.think.spring.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * desc:
 * @author hy
 * @version 1.0
 * @Created on 2017/11/23 16:15
 */
@Component
public class PostProcessor implements InstantiationAwareBeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(PostProcessor.class);

    @Nullable
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (logger.isInfoEnabled() && "userDao".equals(beanName)) {
            logger.info("postProcessBeforeInstantiation => {}",beanName);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (logger.isInfoEnabled() && "userDao".equals(beanName)) {
            logger.info("postProcessAfterInstantiation => {}",beanName);
        }
        return true;
    }

    @Nullable
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (logger.isInfoEnabled() && "userDao".equals(beanName)) {
            logger.info("postProcessPropertyValues => {}",beanName);
        }
        return pvs;
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (logger.isInfoEnabled() && "userDao".equals(beanName)) {
            logger.info("postProcessBeforeInitialization => {}",beanName);
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (logger.isInfoEnabled() && "userDao".equals(beanName)) {
            logger.info("postProcessAfterInitialization => {}", beanName);
        }
        return bean;
    }
}

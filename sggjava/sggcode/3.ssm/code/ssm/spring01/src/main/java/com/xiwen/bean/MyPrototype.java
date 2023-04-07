package com.xiwen.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -18:16
 * @Version: 1.0
 */
public class MyPrototype implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化后");
        return bean;
    }
    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("关闭ioc的时候销毁");
    }
}

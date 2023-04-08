package com.xiwen.controller;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -16:30
 * @Version: 1.0
 */
public class UserControllerTest {

    @Test
    public void setUserService() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ioc.getBean("userController", UserController.class);
        userController.getName();


    }
}
package com.xiwen.service.impl;

import com.xiwen.dao.UserDao;
import com.xiwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -16:20
 * @Version: 1.0
 */


//指定名字
//@Service("userService")
public class UserServiceImpl02 implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void getName() {
        System.out.println("UserServiceImpl02");
    }
}

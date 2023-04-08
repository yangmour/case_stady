package com.xiwen.service.impl;

import com.xiwen.dao.UserDao;
import com.xiwen.service.UserService;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -16:20
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getName() {
        userDao.getName();
    }
}

package com.xiwen.bookstore.service.impl;

import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.dao.UserDao;
import com.xiwen.bookstore.dao.impl.UserDaoImpl;
import com.xiwen.bookstore.service.UserService;
import com.xiwen.bookstore.util.MD5Util;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -21:43
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    private static UserDao userDao = new UserDaoImpl();

   /* @Override
    public boolean register(User user) {
        boolean flag = userDao.selectUserName(user.getUsername());
        if (!flag) {
            return userDao.saveUser(user);
        }
        return false;
    }

    @Override
    public User login(User user) {
        User selectUser = userDao.selectUser(user);
        return selectUser;
    }*/

    @Override
    public boolean register(User user) {
        //md5加密
        user.setPassword(MD5Util.encode(user.getPassword()));
        return userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        User daoUser = userDao.getUser(user);
        if (daoUser != null && MD5Util.encode(user.getPassword()).equals(daoUser.getPassword())) {
            return daoUser;
        }
        return null;
    }

    @Override
    public boolean checkUserName(String checkUserName) {
        boolean f = userDao.selectUserName(checkUserName);
        if (f) {
            return true;
        }
        return false;
    }
}

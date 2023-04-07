package com.xiwen.exercise.dao.impl;

import com.xiwen.exercise.bean.User;
import com.xiwen.exercise.dao.UserDao;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -16:20
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void getName() {
        System.out.println(user.getName());
    }
}

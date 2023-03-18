package com.xiwen.bookstore.dao.impl;

import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.dao.UserDao;
import com.xiwen.bookstore.util.BaseDao;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -21:44
 * @Version: 1.0
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public boolean saveUser(User user) {
        String sql = "insert into users(id,username,password,email) values(null,?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());

    }

    @Override
    public boolean selectUserName(String username) {
        String sql = "select count(*) from users where username = ?";
        Object value = getValue(sql, username);
        Long o = (Long) value;
        if (o == 0) {
            return false;
        }
        return true;
    }

    @Override
    public User selectUser(User user) {
        String sql = "select id,username,email from users where username = ? && password=?";
        User bean = getBean(sql, user.getUsername(), user.getPassword());
        return bean;
    }
}

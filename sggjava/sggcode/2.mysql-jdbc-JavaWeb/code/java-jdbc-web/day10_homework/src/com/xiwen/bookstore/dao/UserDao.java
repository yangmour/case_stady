package com.xiwen.bookstore.dao;

import com.xiwen.bookstore.bean.User;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -22:11
 * @Version: 1.0
 */
public interface UserDao {

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    boolean saveUser(User user);

    User getUser(User user);

}

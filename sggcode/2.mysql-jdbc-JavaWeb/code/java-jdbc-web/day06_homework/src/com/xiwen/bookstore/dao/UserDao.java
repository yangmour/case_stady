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

    /**
     * 查看用户是否重复
     *
     * @param username
     * @return
     */
    boolean selectUserName(String username);

    /**
     * 验证登陆
     *
     * @param user
     * @return
     */
    User selectUser(User user);

    User getUser(User user);

}

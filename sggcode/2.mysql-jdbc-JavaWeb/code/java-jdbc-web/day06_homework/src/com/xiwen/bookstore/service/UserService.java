package com.xiwen.bookstore.service;

import com.xiwen.bookstore.bean.User;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -21:43
 * @Version: 1.0
 */
public interface UserService {
    boolean register(User user);

    User login(User user);
}

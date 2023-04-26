package com.xiwen.boot.service;

import com.xiwen.boot.bean.User;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -09:42
 * @Version: 1.0
 */
public interface UserService {
    List<User> findAll();
}

package com.xiwen.cloud.service;

import com.xiwen.cloud.bean.User;

import java.util.HashMap;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/17 -14:28
 * @Version: 1.0
 */
public interface UserService {
    User getById(Integer id);

    HashMap<String, Object> getMovieAndUserById(Integer id);
}

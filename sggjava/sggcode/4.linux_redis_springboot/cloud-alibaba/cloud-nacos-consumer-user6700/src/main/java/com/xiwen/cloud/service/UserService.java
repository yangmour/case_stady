package com.xiwen.cloud.service;

import com.xiwen.cloud.bean.User;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -11:44
 * @Version: 1.0
 */
public interface UserService {
    User getById(Integer id);

    Map<String,Object> movieAndUser(Integer id);
}

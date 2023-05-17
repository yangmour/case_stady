package com.xiwen.cloud.service.impl;

import com.xiwen.cloud.bean.User;
import com.xiwen.cloud.mapper.UserMapper;
import com.xiwen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/17 -14:29
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public  HashMap<String, Object> getMovieAndUserById(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        User user = userMapper.getById(id);

        map.put("movie", null);
        map.put("user", user);

        return map;
    }
}

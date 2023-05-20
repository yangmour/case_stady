package com.xiwen.cloud.service.impl;

import com.xiwen.cloud.bean.User;
import com.xiwen.cloud.feign.MovieFeignClint;
import com.xiwen.cloud.mapper.UserMapper;
import com.xiwen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -11:44
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MovieFeignClint movieFeignClint;

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public Map<String, Object> movieAndUser(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("movie", movieFeignClint.info(id));
        map.put("user", userMapper.getById(id));
        return map;
    }
}

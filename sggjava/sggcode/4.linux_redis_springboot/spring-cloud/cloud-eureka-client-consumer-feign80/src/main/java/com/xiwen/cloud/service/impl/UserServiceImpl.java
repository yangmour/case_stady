package com.xiwen.cloud.service.impl;

import com.xiwen.cloud.bean.Movie;
import com.xiwen.cloud.bean.User;
import com.xiwen.cloud.mapper.UserMapper;
import com.xiwen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public HashMap<String, Object> getMovieAndUserById(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        User user = userMapper.getById(id);
        Movie movie = restTemplate.getForObject("http://CLOUD-EUREKA-CLIENT-PROVIDER/movie/info/" + id, Movie.class);
        map.put("movie", movie);
        map.put("user", user);

        return map;
    }
}

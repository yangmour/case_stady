package com.xiwen.cloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    // 如果出现超时，异常等可以降级处理，
    // 如：1.程序运行异常
    //    2.超时自动降级
    //    3.服务熔断触发服务降级
    //    4.线程池/信号量打满也会导致服务降级
    //    5.人工降级
    // 处理方式
    //    getMovieAndUserHystrix 是降级处理的方法，
    //    并且要和受保护方法保持一致(参数一致(参数个数、参数类型、参数顺序)、返回值一致)。
    @HystrixCommand(fallbackMethod = "getMovieAndUserHystrix")
    @Override
    public HashMap<String, Object> getMovieAndUserById(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        User user = userMapper.getById(id);
        Movie movie = restTemplate.getForObject("http://CLOUD-EUREKA-CLIENT-PROVIDER/movie/info/" + id, Movie.class);
        map.put("movie", movie);
        map.put("user", user);

        return map;
    }

    public HashMap<String, Object> getMovieAndUserHystrix(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        User user = userMapper.getById(id);
//        Movie movie = restTemplate.getForObject("http://CLOUD-EUREKA-CLIENT-PROVIDER/movie/info/" + id, Movie.class);
        map.put("movie", new Movie(-1, "由于网络原因查询失败，请重试！"));
        map.put("user", user);

        return map;
    }
}

package com.xiwen.cloud.controller;

import com.xiwen.cloud.bean.User;
import com.xiwen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -11:46
 * @Version: 1.0
 */
@RefreshScope // 配置中心更新配置注解
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private Integer port;
    @Value("${jdbc.username}")
    private String username;

    @Value("${datasource.username}")
    private String datasourceUsername;
    @Value("${datasource.password}")
    private String datasourcePassword;
    @Value("${redis.username}")
    private String redisUsername;
    @Value("${cs.aaa}")
    private String aaa;

    @GetMapping("info/{id}")
    public User info(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("movie/{id}")
    public Map<String, Object> movieAndUser(@PathVariable Integer id) {
        System.out.println(port + ":" + username);
        System.out.println("----------------");
        System.out.println(datasourceUsername + ":" + datasourcePassword + ";" + redisUsername + ";" + aaa);
        return userService.movieAndUser(id);
    }

}

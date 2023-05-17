package com.xiwen.cloud.controller;

import com.xiwen.cloud.bean.User;
import com.xiwen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/17 -14:31
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("info/{id}")
    public User info(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @GetMapping("movie/{id}")
    public HashMap<String, Object> movieAndUser(@PathVariable("id") Integer id) {
        return userService.getMovieAndUserById(id);
    }
}

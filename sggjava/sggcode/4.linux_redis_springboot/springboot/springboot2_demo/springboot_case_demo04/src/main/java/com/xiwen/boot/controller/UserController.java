package com.xiwen.boot.controller;

import com.xiwen.boot.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/25 -20:24
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("getAll")
    public Object findAllUser(){
       return userMapper.selectAll();

    }
}

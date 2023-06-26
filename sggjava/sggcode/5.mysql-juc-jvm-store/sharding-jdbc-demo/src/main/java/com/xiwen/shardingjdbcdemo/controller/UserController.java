package com.xiwen.shardingjdbcdemo.controller;

import com.xiwen.shardingjdbcdemo.entity.User;
import com.xiwen.shardingjdbcdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/26 -18:46
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("findAll")
    public Object findAll() {
        List<User> users = userMapper.selectList(null);
        users.stream().forEach(System.out::println);
        return users;
    }
}

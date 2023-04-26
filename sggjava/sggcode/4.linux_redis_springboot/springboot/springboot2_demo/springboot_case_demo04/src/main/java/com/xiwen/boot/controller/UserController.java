package com.xiwen.boot.controller;

import com.xiwen.boot.bean.User;
import com.xiwen.boot.service.UserService;
import com.xiwen.boot.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("findAll")
    public R findAllUser() {
        long start = System.currentTimeMillis();
        List<User> userList = (List<User>) redisTemplate.boundValueOps("userList").get();
        if (userList == null) {
            userList = userService.findAll();
            redisTemplate.boundValueOps("userList").set(userList);
        System.out.println("数据库查询时间" + (System.currentTimeMillis() - start) + "毫秒");
        } else {
            System.out.println("缓存查询时间" + (System.currentTimeMillis() - start) + "毫秒");
        }
        return R.ok("成功", userList);
    }

    @GetMapping("get")
    public R get(User user) {
        System.out.println("user = " + user);
        return R.ok("GET");
    }

    @PostMapping("post")
    public R post(User user, @RequestBody User userBody) {
        System.out.println("user = " + user);
        System.out.println("userBody = " + userBody);
        return R.ok("post");
    }

    @PutMapping("put")
    public R put(User user, @RequestBody User userBody) {
        System.out.println("user = " + user);
        System.out.println("userBody = " + userBody);
        return R.ok("put");
    }

    @DeleteMapping("delete")
    public R delete(User user, @RequestBody User userBody) {
        System.out.println("user = " + user);
        System.out.println("userBody = " + userBody);
        return R.ok("delete");
    }

}

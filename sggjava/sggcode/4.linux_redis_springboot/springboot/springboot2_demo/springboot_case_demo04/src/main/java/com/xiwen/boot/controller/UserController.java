package com.xiwen.boot.controller;

import com.xiwen.boot.bean.User;
import com.xiwen.boot.service.UserService;
import com.xiwen.boot.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("findAll")
    public R findAllUser() {
        return R.ok("成功", userService.findAll());
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

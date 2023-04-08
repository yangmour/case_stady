package com.xiwen.controller;

import com.xiwen.service.UserService;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -16:21
 * @Version: 1.0
 */
public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void getName() {
        userService.getName();
    }

}

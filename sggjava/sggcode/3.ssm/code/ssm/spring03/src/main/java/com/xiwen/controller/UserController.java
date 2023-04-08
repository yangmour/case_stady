package com.xiwen.controller;

import com.xiwen.service.UserService;
import org.springframework.stereotype.Controller;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -16:21
 * @Version: 1.0
 */

/**
 * @Component Service Controller Repository 都是通过component注解实现的，最好见名之意
 */
@Controller
public class UserController {
    //Qualifier自己指定
//    @Qualifier("userServiceImpl")
//    @Autowired

    // jdk的自带的注解也可以最好还是使用spring框架的注解
//    @Resource(name = "userServiceImpl")

//    @Autowired
    private UserService userService;

    public void getName() {
        userService.getName();
    }

}

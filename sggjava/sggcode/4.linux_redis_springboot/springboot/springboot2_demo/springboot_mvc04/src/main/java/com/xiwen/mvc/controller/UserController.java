package com.xiwen.mvc.controller;

import com.xiwen.mvc.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/25 -18:35
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("findAll")
    public List<User> findAll(){
        //查询所有
        List<User> users = new ArrayList<User>();

        User user1 = new User();
        user1.setUsername("杨过");
        user1.setPassword("123456");
        user1.setAge(18);
        user1.setSex("男");

        User user2 = new User();
        user2.setUsername("小龙女");
        user2.setPassword("654321");
        user2.setAge(18);
        user2.setSex("女");

        User user3 = new User();
        user3.setUsername("尹志平");
        user3.setPassword("666666");
        user3.setAge(19);
        user3.setSex("女");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users ;

    }

}

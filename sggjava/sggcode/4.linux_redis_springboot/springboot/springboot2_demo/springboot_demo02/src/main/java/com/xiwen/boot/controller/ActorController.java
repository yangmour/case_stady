package com.xiwen.boot.controller;

import com.xiwen.boot.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/23 -22:40
 * @Version: 1.0
 */
@RestController
@RequestMapping("/actor") //路径名最好和类名一样
public class ActorController {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @GetMapping("hello")
    public String hello(){
        System.out.println(dataSourceProperties);
        System.out.println("访问了hello");
        return "蔡徐坤";
    }
}

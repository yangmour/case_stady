package com.xiwen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/12 -10:00
 * @Version: 1.0
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String toIndexPage() {
        System.out.println("访问了首页！");
        return "index";
    }

    @RequestMapping("hello")
    public String hello() {
        System.out.println("访问了hello！");
        return "success";
    }
}

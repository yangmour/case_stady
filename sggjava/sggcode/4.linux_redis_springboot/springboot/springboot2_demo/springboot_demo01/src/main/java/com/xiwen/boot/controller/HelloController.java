package com.xiwen.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/23 -21:11
 * @Version: 1.0
 */
@RestController //@RestController 等于 @Controller+@ResponseBody注解
@RequestMapping("hello")
public class HelloController {

    @GetMapping("world")
    public String helloWorld() {
        System.out.println("访问了helloWorld方法");
        return "HelloWorld";
    }

}

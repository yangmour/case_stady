package com.xiwen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/12 -10:00
 * @Version: 1.0
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("/index")
    public String toIndexPage() {
        System.out.println("访问了首页！");
        return "index";
    }


    /**
     *  @RequestMapping
     *          value属性：  设置映射路径
     *               value 和path 都可以配置路径,
     *              * 可以只在方法指定路径，但是和其他类的路径可能重复一般不这样做
     *              * 可以只在类上指定路径，但是方法中只能有一个方法可以没有 @RequestMapping注解配置路径
     *              * 可以放在类上，方法上
     *          method属性：  要求请求方式
     *              RequestMethod.POST
     *              RequestMethod.GET
     *              RequestMethod.PUT
     *              RequestMethod.DELETE
     *          简写注解
     *              @GetMapping("/hello")
     *              @PostMapping("/hello")
     *              @PutMapping("/hello")
                    @DeleteMapping("/hello")
      *          params  对请求参数的要求
      *              params ="!username"   要求请求参数中的key不能有username
      *              params ="username"   要求请求参数中的key必须有username
      *              params ="username=root"   要求请求参数中的key必须有username,并且value值必须为root
      *              params ="username!=root"   要求请求参数中的key必须有username,并且value值不能为root
      *              params ={"username=root","password"} )  要求请求参数中的key必须有username,并且value值必须为root,并且key必须有password
      *          headers  对请求头的要求
     *              请求来源
     *              浏览器的产品信息

     */
    @RequestMapping(
            value = "/hello",
            method = {RequestMethod.GET, RequestMethod.POST}
//            params = {"username","abc"}, //指定跳转链接的参数
//            headers = {"Referer=http://localhost:8080/springmvc01/hello/index"} //指定请求头
    )
    public String hello() {
        System.out.println("访问了hello！");
        return "success";
    }
}

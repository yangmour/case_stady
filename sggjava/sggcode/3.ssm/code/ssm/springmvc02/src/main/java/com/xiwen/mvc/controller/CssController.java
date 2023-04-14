package com.xiwen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/css")
public class CssController {

    /**
     * 如果路径重名了会先找controller在找静态资源，如果先找的controller就直接返回了
     * 现在是不重名的
     * @return
     */
    @RequestMapping("/style123.css")
    public String toCss(){
        System.out.println("寻找Controller");
        return "success";
    }
}

package com.xiwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/15 -13:56
 * @Version: 1.0
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("toIndexPage")
    public String toIndexPage(){
        return "index";
    }

}

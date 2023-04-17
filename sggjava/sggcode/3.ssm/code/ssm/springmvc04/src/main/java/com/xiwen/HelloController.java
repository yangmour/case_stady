package com.xiwen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/17 -10:24
 * @Version: 1.0
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
//        String str = null;
//        str.length();
        int a = 10 / 0;
        System.out.println("测试异常");
        return "success";
    }


}

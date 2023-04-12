package com.xiwen.mvc.controller;

import com.xiwen.mvc.bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/12 -16:55
 * @Version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    /**
     * @return
     * @RequestHeader中的属性 a)	value属性：用来设置请求头中的属性名。
     * b)	name属性：与value功能一样，是value的一个别名。
     * c)	required属性：用来设置该请求头中的属性是否是必须的，默认是true。改为false可以不传参数就是默认值
     * d)	defaultValue属性：用来设置一个默认值，如果请求头中没有该属性将使用此值。
     * 如果url的key值与形参中的名字一样可以省略注解如下:
     * @RequestParam Integer gender, String[] hobby
     */
    @RequestMapping("/requestParam")
    public String getRequestParam(@RequestParam("username") String username, @RequestParam("age") Integer age,
                                  @RequestParam(required = false, defaultValue = "1") Integer gender, String[] hobby) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("gender = " + gender);
        System.out.println("hobby = " + Arrays.toString(hobby));
        System.out.println("访问了getRequestParam方法");
        return "success";
    }

    /**
     * 用实体类接收数据
     *
     * @param user
     * @return
     */
    @RequestMapping("/requestParamUser")
    public String getRequestParamUser(UserBean user) {
        System.out.println("user = " + user);
        System.out.println("访问了getRequestParamUser方法");
        return "success";
    }

    /**
     * 获取请求头信息
     *
     * @param referer
     * @return
     */
    @RequestMapping("/requestHarder")
    public String getRequestHarder(@RequestHeader("Referer") String referer) {
        System.out.println("referer = " + referer);
        System.out.println("访问了getRequestParam方法");
        return "success";
    }

    @RequestMapping("/setCookie")
    public String setCookie(HttpServletResponse httpServletResponse) {
        Cookie cookie01 = new Cookie("username", "admin");
        Cookie cookie02 = new Cookie("password", "password");
        httpServletResponse.addCookie(cookie01);
        httpServletResponse.addCookie(cookie02);
        System.out.println("访问了setCookie方法");
        return "success";
    }

    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue("username") String cookie) {
        System.out.println("cookie = " + cookie);
        System.out.println("访问了getCookie方法");
        return "success";
    }


}

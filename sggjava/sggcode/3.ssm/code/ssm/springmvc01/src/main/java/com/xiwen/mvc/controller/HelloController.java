package com.xiwen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
     * @RequestMapping value属性：  设置映射路径
     * value 和path 都可以配置路径,
     * * 可以只在方法指定路径，但是和其他类的路径可能重复一般不这样做
     * * 可以只在类上指定路径，但是方法中只能有一个方法可以没有 @RequestMapping注解配置路径
     * * 可以放在类上，方法上
     * method属性：  要求请求方式
         * RequestMethod.POST
         * RequestMethod.GET
         * RequestMethod.PUT
         * RequestMethod.DELETE
     * 简写注解
         * @GetMapping("/hello")
         * @PostMapping("/hello")
         * @PutMapping("/hello")
         * @DeleteMapping("/hello")
     * params  对请求参数的要求
         * params ="!username"   要求请求参数中的key不能有username
         * params ="username"   要求请求参数中的key必须有username
         * params ="username=root"   要求请求参数中的key必须有username,并且value值必须为root
         * params ="username!=root"   要求请求参数中的key必须有username,并且value值不能为root
         * params ={"username=root","password"} )  要求请求参数中的key必须有username,并且value值必须为root,并且key必须有password
     * headers  对请求头的要求
         * 请求来源
         * 浏览器的产品信息
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

    @RequestMapping(
            {
                    "/a/ant",
                    "/b/ant",
                    "/c/ant",
                    "/?/ant", //?问号代表任意一个字符
                    "/*/ant", //*代表任意字符
                    "/**/ant" //**代表多级任意
            }
    )
    public String antTest() {
        System.out.println("访问了antTest");
        return "success";
    }

    /**
     * hello/param?key1=参数&key2=参数2
     * 直接url上获取对应值的参数
     * @param key1
     * @param key2
     * @return
     */
    @RequestMapping("/param")
    public String getParamTest1(String key1, String key2) {
        System.out.println("访问了getParamTest");
        System.out.println("key1:" + key1);
        System.out.println("key2:" + key2);
        return "success";
    }

    /**
     *
     *  @PathVariable 注解
     *     参数1:value 获取参数
     *     参数2:required 必须的，默认值是true,改为false就是可以没有
     * 前端发送的连接路径：hello/param/value/param2
     * 后端controller接收请求的：@RequestMapping("/param/{aa}/{bb}")
     *
     *      获取路径上两个占位符的数据如：@PathVariable("aa")/@PathVariable("bb")
     * 简写形式
     *      前端发送的连接路径：hello/param/value/param2
     *      后端controller接收请求的：@RequestMapping("/param/{aa}/{bb}")
     *      获取路径上两个占位符的数据如：@PathVariable String aa, @PathVariable String bb
     *      形参名与占位符的名字一致，则value可以省略，
     *      但是如果参数不一致会报错，想解决报错的话需要将注解中的：required = false
     *
     * @param param1
     * @param param2
     * @return
     */
    @RequestMapping("/param/{aa}/{bb}")
//    public String getParamTest2(@PathVariable(value = "aa") String param1, @PathVariable("bb") String param2) {
    public String getParamTest2(@PathVariable(required = false) String aa,@PathVariable(required = false) String bb, @PathVariable(value = "cc", required = false) String cc) {
        System.out.println("访问了getParamTest");
        System.out.println("aa:" + aa);
        System.out.println("bb:" + bb);
        System.out.println("cc:" + cc);
//        System.out.println("param1:" + param1);
//        System.out.println("param2:" + param2);
        return "success";
    }


}

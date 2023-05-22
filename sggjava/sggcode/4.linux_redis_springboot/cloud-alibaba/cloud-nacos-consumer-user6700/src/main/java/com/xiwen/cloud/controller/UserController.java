package com.xiwen.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xiwen.cloud.bean.User;
import com.xiwen.cloud.handler.UserBlockHandler;
import com.xiwen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -11:46
 * @Version: 1.0
 */
@RefreshScope // 配置中心更新配置注解
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private Integer port;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${datasource.username}")
//    private String datasourceUsername;
//    @Value("${datasource.password}")
//    private String datasourcePassword;
//    @Value("${redis.username}")
//    private String redisUsername;
//    @Value("${cs.aaa}")
//    private String aaa;


    @SentinelResource
    @GetMapping("/test1")
    public String test1() {
        System.out.println(System.currentTimeMillis());
        return userService.common();
    }

    @SentinelResource
    @GetMapping("/test2")
    public String test2() {
        System.out.println(System.currentTimeMillis());
        return userService.common();
    }


    //测试关联流控测试
    @SentinelResource(value = "write", blockHandler = "writeBlockHandler", blockHandlerClass = UserBlockHandler.class)
    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @SentinelResource(value = "read", blockHandler = "readBlockHandler", blockHandlerClass = UserBlockHandler.class)
    @GetMapping("/read")
    public String read() {
        return "read";
    }

    /**
     * @SentinelResource: value:用来指定资源名称,随便写，可以和接口地址一致，也可以不一致
     * blockHandler:当违反了sentinel流控、热点key、熔断、授权规则时，走的异常处理方法,指定异常处理方法名
     * 对异常处理方法的要求:
     * 1.要求必须在本类中
     * 2.要求异常处理方法要和原方法一致(参数一致、返回值一致)
     * 3.异常处理方法可以在参数的最后一个参数加BlockException对象，接收异常信息
     * blockHandlerClass:当违反了sentinel流控等规则时，指定异常处理类
     * 1.要求当前异常处理类中的方法和原来一致
     * 2.多了一个要求：要求异常处理类中的方法必须是public static
     * fallback: 指定的是降级方法,返回备份信息
     * 对降级方法的要求:
     * *                      1.要求必须在本类中
     * *                      2.要求降级方法要和原方法一致(参数一致、返回值一致)
     * *                      3.降级方法可以在参数的最后一个参数加Throwable对象，接收异常信息
     * defaultFallback：用来指定一个统一的降级方法,要求：
     * 1.要求必须在本类中
     * *      *                   2.要求降级方法必须是无参的或者在参数的最后一个参数加Throwable对象，接收异常信息
     * fallback指定局部降级方法，defaultFallback指定全局降级方法(针对当前类中所有接口的),如果两个同时存在，以局部的fallback为准!
     * fallbackClass:指定降级类的，一旦降级方法提取到一个降级类中，要求降级方法也必须是public static
     */
    @SentinelResource(value = "info",
            blockHandler = "info2", //流控限制，启用方法名字
            blockHandlerClass = UserBlockHandler.class, //流控限制，将备用方法指定类启用方法
//            fallback = "infoFallback", //降级方法
//            fallbackClass = UserFallBack.class, //将降级方法提前到类里
            defaultFallback = "defaultFallbackMethod" //默认方法
    )
    @GetMapping("info/{id}")
    public User info(@PathVariable Integer id) {
//        if (id == 1) {
//            throw new RuntimeException("测试降级");
//        }
        return userService.getById(id);
    }

    //当前类中的备用方法
//    public User info2(@PathVariable Integer id, BlockException ex) {
//        ex.printStackTrace();
//        return new User(-1, "sentinel测试备用方法", 0, "", "", 0);
//    }


    //降级方法
//    public User infoFallback(@PathVariable Integer id, Throwable e) {
//        e.printStackTrace();
//        return new User(-1, "sentinel测试降级方法", 0, "", "", 0);
//    }

    //defaultFallbackMethod
    public static User defaultFallbackMethod(Throwable e) {
        e.printStackTrace();
        return new User(-1, "sentinel测试默认降级方法", 0, "", "", 0);
    }


    @GetMapping("movie/{id}")
    public Map<String, Object> movieAndUser(@PathVariable Integer id) {
        System.out.println(port);
//        System.out.println(port + ":" + username);
//        System.out.println("----------------");
//        System.out.println(datasourceUsername + ":" + datasourcePassword + ";" + redisUsername + ";" + aaa);
        return userService.movieAndUser(id);
    }

}

package com.xiwen.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/23 -22:26
 * @Version: 1.0
 */

/**
 * 手动创建springboot
 *
 *      * 创建SpringBoot项目四步：
 *      *   1.创建maven工程，引入父工程,规定了jar包版本信息
 *      *   2.引入starter-web依赖，spring、springmvc、json、tomcat、logback
 *      *   3.编写主启动类:@SpringBootApplication、main方法
 *      *   4.编写业务逻辑类：一定要在主启动类所在包或者主启动类所在包的子包下
 *
 */
@SpringBootApplication
public class SpringBootDemo01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo01Application.class, args);
    }
}

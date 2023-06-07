package com.atguigu.syt.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/07 -20:13
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan("com.atguigu")
public class ServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }
}

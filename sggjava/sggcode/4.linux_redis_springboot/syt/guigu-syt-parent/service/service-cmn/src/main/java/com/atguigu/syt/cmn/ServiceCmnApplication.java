package com.atguigu.syt.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/31 -10:35
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan("com.atguigu")
//@EnableCaching //开启spring-cache缓存
public class ServiceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class, args);
    }
}

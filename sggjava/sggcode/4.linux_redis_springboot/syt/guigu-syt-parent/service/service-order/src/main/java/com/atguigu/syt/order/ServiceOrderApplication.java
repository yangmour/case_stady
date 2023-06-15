package com.atguigu.syt.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -14:43
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan("com.atguigu")
@MapperScan("com.atguigu.syt.order.mapper")
@EnableFeignClients("com.atguigu")
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}

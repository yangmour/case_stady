package com.xiwen.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xiwen.cloud.mapper")
public class CloudEurekaClientConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClientConsumer80Application.class, args);
    }

}

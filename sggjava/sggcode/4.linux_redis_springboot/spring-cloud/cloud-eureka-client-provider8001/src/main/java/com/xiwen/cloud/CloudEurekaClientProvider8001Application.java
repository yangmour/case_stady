package com.xiwen.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.xiwen.cloud.mapper")
public class CloudEurekaClientProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClientProvider8001Application.class, args);
    }

}

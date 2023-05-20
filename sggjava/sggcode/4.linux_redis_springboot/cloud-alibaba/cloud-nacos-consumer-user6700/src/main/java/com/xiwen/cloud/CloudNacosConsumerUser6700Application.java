package com.xiwen.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xiwen.cloud.mapper")
public class CloudNacosConsumerUser6700Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConsumerUser6700Application.class, args);
    }

}

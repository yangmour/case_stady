package com.xiwen.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@MapperScan("com.xiwen.cloud.mapper")
public class CloudNacosConsumerUser6700Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConsumerUser6700Application.class, args);
    }

}

package com.xiwen.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker // 开启断路保护功能
@MapperScan("com.xiwen.cloud.mapper")
@EnableFeignClients //开启fegin客户端
public class CloudEurekaClientConsumerFeign80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClientConsumerFeign80Application.class, args);
    }

}

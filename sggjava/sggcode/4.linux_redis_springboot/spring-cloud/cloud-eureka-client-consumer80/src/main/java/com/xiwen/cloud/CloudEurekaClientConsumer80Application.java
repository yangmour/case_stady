package com.xiwen.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

//@SpringBootApplication
//@EnableEurekaClient
//@EnableHystrix //断路保护功能
@SpringCloudApplication // @SpringCloudApplication=@SpringBootApplication+@EnableDiscoveryClient+@EnableCircuitBreaker
@MapperScan("com.xiwen.cloud.mapper")
public class CloudEurekaClientConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClientConsumer80Application.class, args);
    }

}

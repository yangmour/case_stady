package com.xiwen.oracle11g;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiwen.oracle11g.mapper")
public class SpringBootOracle11gDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOracle11gDemo01Application.class, args);
    }

}

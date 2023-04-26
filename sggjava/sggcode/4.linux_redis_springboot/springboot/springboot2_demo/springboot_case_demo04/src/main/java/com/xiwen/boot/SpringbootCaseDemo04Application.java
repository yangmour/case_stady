package com.xiwen.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xiwen.boot.mapper")
public class SpringbootCaseDemo04Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCaseDemo04Application.class, args);
    }

}

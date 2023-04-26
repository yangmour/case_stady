package com.xiwen.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -16:02
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.xiwen.system.mapper")
public class ServiceSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSystemApplication.class, args);
    }
}

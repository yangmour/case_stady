package com.xiwen.ggkt.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -22:54
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan("com.xiwen.ggkt")
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
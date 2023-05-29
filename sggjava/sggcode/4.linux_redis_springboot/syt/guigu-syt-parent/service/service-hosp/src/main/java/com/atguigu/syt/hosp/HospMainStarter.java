package com.atguigu.syt.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/29 -14:24
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan("com.atguigu")
public class HospMainStarter {
    public static void main(String[] args) {
        SpringApplication.run(HospMainStarter.class, args);
    }
}

package com.atguigu.syt.doingcron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/19 -20:01
 * @Version: 1.0
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
})
@ComponentScan("com.atguigu")
@EnableScheduling // 开启定时任务
@EnableFeignClients(basePackages = "com.atguigu")
public class ServiceDoingCronApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDoingCronApplication.class, args);
    }
}

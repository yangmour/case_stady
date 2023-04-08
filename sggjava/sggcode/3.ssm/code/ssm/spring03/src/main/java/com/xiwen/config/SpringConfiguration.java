package com.xiwen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/08 -11:12
 * @Version: 1.0
 */
// 完全注解开发扫描包
@ComponentScan(basePackages = "com.xiwen")
@Configuration
public class SpringConfiguration {
}

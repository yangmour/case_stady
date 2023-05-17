package com.xiwen.cloud.config;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/17 -15:26
 * @Version: 1.0
 */

import feign.Logger;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class RestTemplateConfig {

    @LoadBalanced // 开启客户端负载均衡默认是轮训
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    // 全局配置负载均衡
//    @Bean
//    public IRule getIRule() {
//        //设置一个随机的复制均衡算法测试用，还有很多只需要配置一下就可以
//        return new RandomRule();
//    }

    // 配置feign的日志
    @Bean
    public Logger.Level getLevel() {
        /*
         * NONE：默认的，不显示任何日志
         * BASIC：仅记录请求方法、RUL、响应状态码及执行时间
         * HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息
         * FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据
         */
        return Logger.Level.FULL;
    }

}

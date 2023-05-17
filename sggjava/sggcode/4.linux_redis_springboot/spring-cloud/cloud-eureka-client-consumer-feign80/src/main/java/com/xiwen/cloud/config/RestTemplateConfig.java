package com.xiwen.cloud.config;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/17 -15:26
 * @Version: 1.0
 */

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

}

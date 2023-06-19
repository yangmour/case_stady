package com.atguigu.common.service.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    public MessageConverter messageConverter(){
        //配置json字符串转换器，默认使用SimpleMessageConverter
        return new Jackson2JsonMessageConverter();
    }
}
package com.xiwen.boot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/16 -16:27
 * @Version: 1.0
 */
@SpringBootConfiguration
public class RabbitmqListenerConfig {

    @Bean(value = "exchange")
    public Exchange geExchange() {
        return ExchangeBuilder.topicExchange("springboot-topic-test01")
                .build();
    }

    @Bean
    public Queue getQueue() {
        return QueueBuilder.durable("springboot-topic-queue-test01")
                .build();
    }

    @Bean
    public Binding getBinding(@Qualifier("exchange") Exchange exchange, @Qualifier("getQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("a.#")
                .noargs();
    }

}

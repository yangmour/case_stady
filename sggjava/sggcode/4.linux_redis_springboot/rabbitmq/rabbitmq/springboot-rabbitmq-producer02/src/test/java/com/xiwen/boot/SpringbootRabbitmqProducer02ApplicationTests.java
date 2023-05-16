package com.xiwen.boot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqProducer02ApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("springboot-topic-test02", "a.b.c", "这是一条测试上springboot的消息".getBytes());
    }

    @Test
    void contextLoads2() {
        rabbitTemplate.convertAndSend("springboot-topic-test03", "a.b.c", "这是一条测试上springboot的消息".getBytes());
    }

}

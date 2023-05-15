package com.xiwen.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -16:45
 * @Version: 1.0
 */
@ContextConfiguration(locations = "classpath:applicationContext-rabbitmq-producer.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void simpleTest() {
        rabbitTemplate.convertAndSend("spring-queue", "spring整合rabbitmq");
    }
}

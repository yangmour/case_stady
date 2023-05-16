package com.xiwen.boot.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/16 -16:26
 * @Version: 1.0
 */
@Component
public class RabbitmqListener {
    @RabbitListener(queues = "springboot-topic-queue-test01")
    public void listenerQueue(Message message) {
        System.out.println("这是消费者:" + new String(message.getBody()));
    }
}

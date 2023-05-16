package com.xiwen.boot.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/16 -18:30
 * @Version: 1.0
 */
@Component
public class RabbitmqQueueListener {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue("springboot-topic-queue-test02"),
                    exchange = @Exchange(value = "springboot-topic-test02", type = "topic"),
                    key = "a.#"
            )
    })
    public void queueMessageListener(Message message, Channel channel) {
        System.out.println(new String(message.getBody()));
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue("mirror-springboot-topic-queue-test03"),
                    exchange = @Exchange(value = "springboot-topic-test03", type = "topic"),
                    key = "a.#"
            )
    })
    public void queueMessageListener2(Message message, Channel channel) {
        System.out.println(new String(message.getBody()));
    }
}

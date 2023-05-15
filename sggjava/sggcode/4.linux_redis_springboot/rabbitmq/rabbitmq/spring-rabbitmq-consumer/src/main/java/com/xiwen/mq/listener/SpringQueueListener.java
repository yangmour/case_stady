package com.xiwen.mq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -16:54
 * @Version: 1.0
 */
public class SpringQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message.getMessageProperties().getReceivedExchange());
        System.out.println(message.getMessageProperties().getReceivedRoutingKey());
        System.out.println(message.getMessageProperties().getConsumerTag());
        System.out.println(message.getMessageProperties().getDeliveryTag());

        System.out.println(new String(message.getBody()));
    }
}

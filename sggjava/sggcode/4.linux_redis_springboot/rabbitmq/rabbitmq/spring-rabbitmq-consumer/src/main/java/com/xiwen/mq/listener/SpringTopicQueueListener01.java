package com.xiwen.mq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -18:30
 * @Version: 1.0
 */
public class SpringTopicQueueListener01 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("消费者1:" + new String(message.getBody()));
    }
}

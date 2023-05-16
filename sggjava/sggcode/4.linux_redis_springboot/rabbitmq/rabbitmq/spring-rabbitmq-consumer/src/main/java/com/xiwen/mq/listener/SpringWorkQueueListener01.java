package com.xiwen.mq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -18:30
 * @Version: 1.0
 */
public class SpringWorkQueueListener01 implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println("消费者1:" + new String(message.getBody()));
        Thread.sleep(30);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}

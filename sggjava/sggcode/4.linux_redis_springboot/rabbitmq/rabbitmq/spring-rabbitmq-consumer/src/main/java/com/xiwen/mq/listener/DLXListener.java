package com.xiwen.mq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/16 -16:09
 * @Version: 1.0
 */
public class DLXListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            System.out.println(new String(message.getBody()));
            int a = 10 / 0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }
}

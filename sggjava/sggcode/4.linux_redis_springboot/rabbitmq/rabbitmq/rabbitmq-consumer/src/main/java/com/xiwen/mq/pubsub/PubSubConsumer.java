package com.xiwen.mq.pubsub;

import com.rabbitmq.client.*;
import com.xiwen.util.ConnectionUtils;

import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -14:00
 * @Version: 1.0
 */
public class PubSubConsumer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("pubsub-queue2", true, false, false, null);
        channel.queueBind("pubsub-queue", "pubsub-exchange2", "");
        channel.basicConsume("pubsub-queue2", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });


    }
}

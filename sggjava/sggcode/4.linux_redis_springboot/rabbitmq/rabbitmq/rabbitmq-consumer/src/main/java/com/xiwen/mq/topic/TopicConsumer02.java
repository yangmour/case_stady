package com.xiwen.mq.topic;

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
public class TopicConsumer02 {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("topic-queue02", true, false, false, null);
        channel.queueBind("topic-queue02", "topic-exchange", "*.*.rabbit");
        channel.queueBind("topic-queue02", "topic-exchange", "lazy.#");
        channel.basicConsume("topic-queue02", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1:" + new String(body));
            }
        });


    }
}

package com.xiwen.mq.routing;

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
public class RoutingConsumer02 {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("routing-queue02", true, false, false, null);
        channel.queueBind("routing-queue02", "routing-exchange", "error");
        channel.queueBind("routing-queue02", "routing-exchange", "info");
        channel.basicConsume("routing-queue02", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2:" + new String(body));
            }
        });


    }
}

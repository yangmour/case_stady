package com.xiwen.mq;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.xiwen.util.ConnectionUtils;

public class Consumer {
    public static void main(String[] args) throws Exception {
        // 3.创建连接
        Connection connection = ConnectionUtils.getConnection();
        // 4.获取Channel通道
        Channel channel = connection.createChannel();

        // 5.接收消息
        channel.basicConsume("simple_queue", false, new DefaultConsumer(channel) {

            /**
             * consumerTag：消费者唯一标识符
             * envelope: 信封，封装的是 交换机、路由key、消息的唯一标识等信息
             * properties: 消息本身的属性
             * body:消息本身
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {
                System.out.println("消费者唯一标识:" + consumerTag);
                System.out.println("交换机:" + envelope.getExchange());
                System.out.println("路由key:" + envelope.getRoutingKey());
                System.out.println("消息的唯一标识:" + envelope.getDeliveryTag());
                System.out.println("消息本身" + new String(body));

                try {
                    int a = 10 / 0;
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (Exception e) {
                    channel.basicNack(envelope.getDeliveryTag(), false, true);
                    e.printStackTrace();
                }
            }

        });
    }

}

package com.xiwen.mq.workqueue;

import com.rabbitmq.client.*;
import com.xiwen.util.ConnectionUtils;

import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -09:56
 * @Version: 1.0
 */
public class WorkQueueConsumer2 {
    public static void main(String[] args) throws Exception {
        //1.获取连接
        Connection connection = ConnectionUtils.getConnection();
        //2.创建通道
        Channel channel = connection.createChannel();
        //3.消费队列中的消息
        channel.basicConsume("work-queue", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2:" + new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        });
    }
}

package com.xiwen.mq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xiwen.util.ConnectionUtils;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -14:26
 * @Version: 1.0
 */
public class TopicProducer {
    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        // 设置交换机
        channel.exchangeDeclare("topic-exchange", "topic");
        channel.basicPublish("topic-exchange", "lazy.orange.b", null, "第5个测topic路由模式1".getBytes());
        channel.basicPublish("topic-exchange", "a.b.rabbit", null, "第5个测topic路由模式2".getBytes());
        ConnectionUtils.close(channel, connection);
    }
}

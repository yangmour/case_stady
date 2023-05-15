package com.xiwen.mq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.xiwen.util.ConnectionUtils;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -13:48
 * @Version: 1.0
 */
public class PubSubProducer {
    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        // 设置交换机 durable设置了持久化
        channel.exchangeDeclare("pubsub-exchange2", "fanout", true);
        // durable设置了持久化
        channel.queueDeclare("pubsub-queue", true, false, false, null);
        //MessageProperties.PERSISTENT_TEXT_PLAIN消息设置了持久化
        channel.basicPublish("pubsub-exchange2", "", MessageProperties.PERSISTENT_TEXT_PLAIN, "第三个测试交换机".getBytes());
        ConnectionUtils.close(channel, connection);

    }
}

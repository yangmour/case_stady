package com.xiwen.mq.routing;

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
public class RoutingProducer {
    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        // 设置交换机
        channel.exchangeDeclare("routing-exchange", "direct");
        channel.basicPublish("routing-exchange", "error", null, "第4个测routing路由模式1".getBytes());
        channel.basicPublish("routing-exchange", "info", null, "第4个测routing路由模式2".getBytes());
        ConnectionUtils.close(channel, connection);
    }
}

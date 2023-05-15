package com.xiwen.mq.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xiwen.util.ConnectionUtils;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -09:51
 * @Version: 1.0
 */
public class WorkQueueProducer {
    public static void main(String[] args) throws Exception {
        //1.获取连接
        Connection connection = ConnectionUtils.getConnection();
        //2.获取通道
        Channel channel = connection.createChannel();
        //3.生命队列
        channel.queueDeclare("work-queue", true, false, false, null);
        for (int i = 0; i < 20; i++) {
            // 4.发布消息
            channel.basicPublish("", "work-queue", null, ("测试能者多劳+" + i).getBytes());
        }
        //5.释放资源
        ConnectionUtils.close(channel, connection);

    }
}

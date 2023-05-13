package com.xiwen.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SimpleSend {
    public static void main(String[] args) throws Exception {
        // 1.创建工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2.设置参数
        // 主机地址;默认为 localhost
        connectionFactory.setHost("192.168.232.201");
        // 连接端口;默认为 5672
        connectionFactory.setPort(5672);
        // 虚拟主机名称;默认为 /
        connectionFactory.setVirtualHost("/admin");
        // 连接用户名；默认为guest
        connectionFactory.setUsername("awen");
        // 连接密码；默认为guest
        connectionFactory.setPassword("awen123");
        // 3.创建连接d
        Connection connection = connectionFactory.newConnection();

        // 4.获取Channel通道
        Channel channel = connection.createChannel();

        // 5.获取队列
        channel.queueDeclare("simple_queue", true, false, false, null);
        ;

        // 6.发送消息
        channel.basicPublish("", "simple_queue", null, "这是一条消息".getBytes());
        // 7.关闭连接
        channel.close();
        connection.close();
    }
}

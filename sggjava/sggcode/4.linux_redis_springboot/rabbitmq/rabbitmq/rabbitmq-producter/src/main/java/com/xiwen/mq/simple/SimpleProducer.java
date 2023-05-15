package com.xiwen.mq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.xiwen.util.ConnectionUtils;

public class SimpleProducer {

    public static void main(String[] args) throws Exception {

        // 3.创建连接
        Connection connection = ConnectionUtils.getConnection();
        // 4.获取Channel通道
        Channel channel = connection.createChannel();

        // 5.获取队列
        channel.queueDeclare("simple_queue", true, false, false, null);
        ;

        // 6.发送消息
        channel.basicPublish("", "simple_queue", null, "这是一条消息".getBytes());
        // 7.关闭连接
        ConnectionUtils.close(channel, connection);
    }

    public static void main1(String[] args) throws Exception {
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
        // 3.创建连接
        Connection connection = connectionFactory.newConnection();

        // 4.获取Channel通道
        Channel channel = connection.createChannel();

        // 5.创建队列
        /**
         * String queue, boolean durable, boolean exclusive, boolean autoDelete,
         * Map<String, Object> arguments
         * queue: 指定队列名称
         * durable：当前队列是否支持持久化，true表示支持持久化，false表示不支持持久化，一般设置为true
         * exclusive: 表示是否支持独占该队列,true表示支持独占,通常设置为false
         * autoDelete: 表示是否支持自动删除，true表示支持，通常设置为false
         * arguments:表示设置队列的其它信息,暂时不设置，暂时设置为null
         */
        channel.queueDeclare("simple_queue", true, false, false, null);
        ;

        // 6.生产者通过channel通道把消息发送到Queue中
        /**
         * String exchange, String routingKey, BasicProperties props, byte[] body
         * exchange:表示交换机名称,没有暂时设置为"",
         * routingKey:表示路由key,暂时让队列名称充当路由key
         * BasicProperties:消息本身的属性，暂时设置为null
         * body:表示消息本身的内容
         */
        channel.basicPublish("", "simple_queue", null, "这是一条消息".getBytes());
        // 7.关闭连接
        channel.close();
        connection.close();
    }
}

package com.xiwen.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/13 -21:31
 * @Version: 1.0
 */
public class ConnectionUtils {
    public static Connection getConnection() throws Exception {
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
        return connectionFactory.newConnection();
    }

    public static void close(Channel channel, Connection connection) throws Exception {
        if (channel != null) {
            channel.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}

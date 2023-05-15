package com.xiwen.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -16:45
 * @Version: 1.0
 */
@ContextConfiguration(locations = "classpath:applicationContext-rabbitmq-producer.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void simpleTest() {
        rabbitTemplate.convertAndSend("spring-queue", "spring整合rabbitmq");
    }

    @Test
    public void workTest() {
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("spring-queue-work", "spring整合rabbitmq的work版" + i);
        }
    }

    @Test
    public void pubsubTest() {
        rabbitTemplate.convertAndSend("spring-pubsub-exchange", "", "spring整合rabbitmq的广播交换机版");
    }

    @Test
    public void routingTest() {
        rabbitTemplate.convertAndSend("spring-routing-exchange", "error", "spring整合rabbitmq的路由交换机版1");
        rabbitTemplate.convertAndSend("spring-routing-exchange", "info", "spring整合rabbitmq的路由交换机版2");
    }

    @Test
    public void topicTest() {
        rabbitTemplate.convertAndSend("spring-topic-exchange", "lazy.orange.a", "spring整合rabbitmq的模式匹配交换机版1");
        rabbitTemplate.convertAndSend("spring-topic-exchange", "a.b.rabbit", "spring整合rabbitmq的模式匹配交换机版2");
    }

    @Test
    public void confirmTest() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    //接收成功
                    System.out.println("接收成功消息:" + cause);
                } else {
                    //接收失败
                    System.out.println("接收失败消息" + cause);
                    //做一些处理让消息再次发送
                }
            }
        });
        rabbitTemplate.convertAndSend("spring-topic-exchange", "lazy.orange.a", "spring整合rabbitmq的模式匹配交换机版");
        rabbitTemplate.convertAndSend("spring-topic-exchange2", "lazy.orange.a", "spring整合rabbitmq的模式匹配交换机版");
    }

    @Test
    public void returnTest() {
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println(message);
                System.out.println(replyCode);
                System.out.println(replyText);
                System.out.println(exchange);
                System.out.println(routingKey);
            }
        });
        rabbitTemplate.convertAndSend("spring-topic-exchange2", "lazy.orange.a.a.a", "spring整合rabbitmq的模式匹配交换机版");
    }
}

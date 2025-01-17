package com.example.kafkaproducter;

import com.example.kafkaproducter.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@SpringBootTest
@Slf4j
class KafkaProducterApplicationTests {

    @Resource
    KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 1.发送字符串
     * @throws IOException
     */
    @Test
    void sendMsg() throws IOException {
        //参数1：主题名称
        //参数2：消息内容
        kafkaTemplate.send("spring-test-topic","hello,Kafka");
        //阻塞：避免回调未执行时线程结束
        System.in.read();
    }

    /**
     * 2.发送对象
     * @throws IOException
     */
    @Test
    void sendMsg2() throws IOException {
//      kafkaTemplate.send("spring_test_topic","hello,Kafka3");
        kafkaTemplate.send("spring_test_topic",new UserDTO("pangju",39,"13512345678"));
        //阻塞：避免回调未执行时线程结束
        System.in.read();
    }


    /**
     *
     * **如何保证单分区内数据有序or怎么解决乱序？**
     *
     * **解决方案：**
     * **通过将指定key的消息发送到同一个分区，可以保证消息的局部有序，因为Kafka可以保证同一个分区的消息是严格有序的，然后设置retries等于0**
     * @throws IOException
     */
    @Test
    void sendMsgBysendMsgSamePartition3() throws IOException, ExecutionException, InterruptedException {
        log.info("partition={}", kafkaTemplate.send("spring_test_topic", "b", "ordered_data1").get().getRecordMetadata().partition());
        log.info("partition={}", kafkaTemplate.send("spring_test_topic", "b", "ordered_data1").get().getRecordMetadata().partition());
    }


    //添加事务注解：会自动回滚
    @Transactional
    @Test
    void sendMsg4()  {
        //        kafkaTemplate.send("spring_test_topic","key","trans_data1");
        //        int i = 1/0;
        //        kafkaTemplate.send("spring_test_topic","trans_data2");
        //事务多消息发送：和上面效果一致
        kafkaTemplate.executeInTransaction(operations -> {
            operations.send("spring_test_topic","key","trans_data1");
            int i = 1/0;
            operations.send("spring_test_topic","key","trans_data2");
            return true;
        });
    }
    @Test
    void contextLoads() {
    }

    //测试消费者

    /**
     * 分区消费
     */
    @Test
    void sendPartitionMsg(){
        for (int i = 0; i < 3; i++) {
            log.info("发送条数i = {}", i);
            kafkaTemplate.send("spring_test_partition_topic",i,"","simple_data"+i+"_"+ LocalDateTime.now());
        }
    }


    /**
     * 手动ack确认
     */
    @Test
    void sendAckMsg(){
        for (int i = 1; i < 5; i++) {
            kafkaTemplate.send("spring_test_ack_topic",0,"","offset_data"+i+"_"+ LocalDateTime.now());
        }
    }


    /**
     * 消费异常处理
     */
    @Test
    void sendAckMsgWithExp(){
        kafkaTemplate.send("spring_test_ack_topic_withExp",0,"","offset_data"+"_withExp"+ LocalDateTime.now());
    }

    /**
     * 消费实体
     */
    @Test
    void sendAckMsgWithDto(){
        kafkaTemplate.send("spring_test_ack_topic_dto",0,"",new UserDTO("卡布奇诺", 10, "9999999"));
    }

    /**
     * 消费重试->死信队列
     */
    @Test
    void sendRertyMsg(){
        for (int i = 1; i < 2; i++) {
            kafkaTemplate.send("spring_test_retry_topic",0,"",new UserDTO("测试" + i, 10, "9999999"));
        }
    }

}

package com.xiwen.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/15 -18:10
 * @Version: 1.0
 */
@ContextConfiguration(locations = "classpath:applicationContext-rabbitmq-consumer.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConsumerTest {
    @Test
    public void test() {
        while (true);
    }
}

package com.xiwen.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/10 -09:59
 * @Version: 1.0
 */
@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int add = calculator.add(10, 5);

        System.out.println(add);
    }
}

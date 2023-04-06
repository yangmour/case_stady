package com.xiwen;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/06 -16:57
 * @Version: 1.0
 */
public class HelloWorldTest {

    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object helloWorld = ioc.getBean("helloWorld");
        System.out.println(helloWorld);
    }
}

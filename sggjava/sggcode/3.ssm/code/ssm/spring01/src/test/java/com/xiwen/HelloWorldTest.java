package com.xiwen;

import com.xiwen.bean.Car;
import com.xiwen.bean.Employee;
import org.junit.Before;
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

    private ApplicationContext ioc;

    @Before
    public void init() {
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test() {
        Object helloWorld = ioc.getBean("helloWorld");
        System.out.println(helloWorld);
    }

    @Test
    public void test02() {

        Object helloWorld = ioc.getBean("helloWorld");
        System.out.println(helloWorld);

        Car car = ioc.getBean(Car.class);
        System.out.println(car);

        Employee employee01 = ioc.getBean("employee01", Employee.class);
        System.out.println(employee01);


        Object employee02 = ioc.getBean("employee02");
        System.out.println(employee02);

    }
}

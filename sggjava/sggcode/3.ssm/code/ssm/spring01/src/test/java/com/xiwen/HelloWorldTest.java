package com.xiwen;

import com.xiwen.bean.Car;
import com.xiwen.bean.CollectionBean;
import com.xiwen.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/06 -16:57
 * @Version: 1.0
 */
public class HelloWorldTest {

    private ApplicationContext ioc;
    private ApplicationContext ioc2;

    @Before
    public void init() {
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        ioc2 = new ClassPathXmlApplicationContext("applicationContext02.xml");
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


    @Test
    public void test03() {

        Object employee03 = ioc.getBean("employee03");
        System.out.println(employee03);

        Object emp04 = ioc.getBean("emp04");
        System.out.println(emp04);

        Object emp05 = ioc.getBean("emp05");
        System.out.println(emp05);

        Object emp06 = ioc.getBean("emp06");
        System.out.println("emp06 = " + emp06);
        System.out.println(emp04);

        List<Car> cars = (List<Car>) ioc.getBean("cars");
        System.out.println("cars = " + cars);
    }

    @Test
    public void test04() {

       /* int[] arr;
        List<String> strings;
        List<Car> cars;
        Set<String> sets;
        Set<Car> setCars;
        Map<String, String> map;
        Map<String, Car> carMap;
        Properties properties;  */

        CollectionBean collectionBean = (CollectionBean) ioc.getBean("collectionBean");
        System.out.println("collectionBean.getArr() = " + Arrays.toString(collectionBean.getArr()));
        System.out.println("collectionBean.getStrings() = " + collectionBean.getStrings());
        System.out.println("collectionBean.getStrings() = " + collectionBean.getCars());
        System.out.println("collectionBean.getStrings() = " + collectionBean.getSets());
        System.out.println("collectionBean.getStrings() = " + collectionBean.getSetCars());
        System.out.println("collectionBean.getStrings() = " + collectionBean.getMap());
        System.out.println("collectionBean.getStrings() = " + collectionBean.getCarMap());
        System.out.println("collectionBean.getStrings() = " + collectionBean.getProperties());
    }

    @Test
    public void test05(){
        Object employee01 = ioc2.getBean("employee01");
        System.out.println(employee01);
    }
}

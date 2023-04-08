package com.xiwen.controller;

import com.xiwen.aop01.*;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/08 -15:09
 * @Version: 1.0
 */
public class Aop01Test {

    @Test
    public void test01() {
        Calculator calculator = new CalculatorImpl();
        Calculator proxy = (Calculator) new LoggingProxy(calculator).getProxy();
        int add = proxy.add(10, 5);
        System.out.println(add);
    }

    @Test
    public void test02() {
        //自己改了改
        Calculator calculator = new CalculatorImpl();
        Calculator proxy = (Calculator) new LoggingProxyOther(calculator, new Other() {
            @Override
            public void after(Object proxy, Method method, Object[] args) {
                System.out.println("执行前");
            }

            @Override
            public void before(Object proxy, Method method, Object[] args, Object res) {
                System.out.println("执行后");
            }
        }).getProxy();
        int add = proxy.add(10, 5);
        System.out.println(add);
    }
}

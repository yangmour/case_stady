package com.xiwen.aop01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/08 -15:28
 * @Version: 1.0
 */

public class LoggingProxy {

    private Object target;


    public LoggingProxy(Object o) {
        target = o;
    }


    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("这是" + method.getName() + "方法,参数是" + Arrays.toString(args));
                Object res = method.invoke(target, args);
                System.out.println(method.getName() + "运算已完成，结果为:" + res);

                return res;
            }
        });
    }


}


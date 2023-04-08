package com.xiwen.aop01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/08 -15:03
 * @Version: 1.0
 */


public class LoggingProxyOther implements Other {

    private Object target;
    public Other other;


    public LoggingProxyOther(Object o, Other other) {
        target = o;
        this.other = other;
    }

    public LoggingProxyOther(Object o) {
        target = o;
    }

    public void after(Object proxy, Method method, Object[] args) {
        System.out.println("这是" + method.getName() + "方法,参数是" + Arrays.toString(args));
    }

    public void before(Object proxy, Method method, Object[] args, Object res) {
        System.out.println(method.getName() + "运算已完成，结果为:" + res);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (other == null) {
                    after(proxy, method, args);
                } else {
                    other.after(proxy, method, args);
                }
                Object res = method.invoke(target, args);
                if (other == null) {
                    before(proxy, method, args, res);
                } else {
                    other.before(proxy, method, args, res);
                }

                return res;
            }
        });
    }


}

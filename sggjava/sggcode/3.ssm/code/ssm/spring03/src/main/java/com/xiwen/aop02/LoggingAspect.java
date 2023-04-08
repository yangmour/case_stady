package com.xiwen.aop02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/08 -16:43
 * @Version: 1.0
 */
@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public int com.xiwen.aop02.Calculator.add(int ,int))")
    public void before() {
        System.out.println("任务完成前执行！");
    }

    @After("execution(public int com.xiwen.aop02.Calculator.add(int ,int))")
    public void after() {
        System.out.println("任务完成后执行！");
    }

}

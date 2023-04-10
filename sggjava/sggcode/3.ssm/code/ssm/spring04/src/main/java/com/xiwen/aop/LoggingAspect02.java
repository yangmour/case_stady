package com.xiwen.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
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
public class LoggingAspect02 implements Ordered {

    @Pointcut("execution(* *.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("任务完成前执行02！");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("任务完成后执行02！");
    }


    @Override
    public int getOrder() {
        return 5;
    }
}

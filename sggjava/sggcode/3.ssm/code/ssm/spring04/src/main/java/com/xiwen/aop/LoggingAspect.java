package com.xiwen.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/08 -16:43
 * @Version: 1.0
 */

/**
 * 切面的优先级数值越小优先级越高
 * 方式1继承接口ordered实现getOrder方法
 * 方式2使用order注解设置value值
 */
@Component
@Aspect
@Order(1)
public class LoggingAspect {
//public class LoggingAspect implements Ordered {

    /**
     * 具体的方向切入点
     * execution(public int com.xiwen.aop.Calculator.add(int ,int))
     * 参数不固定的方法切入
     * execution(int Calculator.add(..))
     * 参数以String为结尾的切入点，也可以String为开头的为切入点
     * execution(public int Calculator.add(..,String))
     * 任意方法的符号*
     * execution(int Calculator.*(..))
     * 任意类的任意方法的符号*
     * execution(int *.*(..))
     * 任意类的任意方法的任意返回值的符号*
     * execution(int *.*(..))
     * <p>
     * 逻辑运算符
     * execution(public int com.xiwen.aop.Calculator.add(int ,int)) || execution(public int com.xiwen.aop.Calculator.add(int ,int))
     * execution(public int com.xiwen.aop.Calculator.add(int ,int)) && execution(public int com.xiwen.aop.Calculator.add(int ,int))
     * !execution(public int com.xiwen.aop.Calculator.add(int ,int))
     */

    @Pointcut("execution(* *.*(..))")
    public void pointCut() {
    }

    /**
     * 获取切入点信息 获取方法名或者形参
     *
     * @param joinPoint
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("方法名:" + joinPoint.getSignature().getName());
        System.out.println("参数" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("任务完成前执行！");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("任务完成后执行！");
    }

    /**
     * after 和 afterReturning
     * 在注解里是先执行afterReturning的方法在执行after的方法
     * 如果是在配置文件中是按照xml配置的先后顺序执行
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("获取结果" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("出现异常" + e.getMessage());
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {

        String name = pjp.getSignature().getName();
        System.out.println("*name = " + name);
        System.out.println("*ages = " + Arrays.toString(pjp.getArgs()));
        System.out.println("*任务完成前执行！");
        Object proceed = null;

        try {
            //执行
            proceed = pjp.proceed();
            System.out.println("*获取结果：" + proceed);

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("*出现异常" + e.getMessage());
        } finally {
            System.out.println("*任务完成后执行！");
        }
        return proceed;
    }

//    @Override
//    public int getOrder() {
//        return 10;
//    }
}

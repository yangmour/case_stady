package com.xiwen.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-18:31
 * @Version: 1.0
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "";

    String[] value2() default "";

}

@MyAnnotation(value = "希文", value2 = "你好啊！")
class MyAnnotationTest {
    private int id;

    @MyAnnotation(value = "测试方法")
    public void show() {
        System.out.println("哈哈哈");
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.xiwen.test.annotation.MyAnnotationTest");
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            String value = annotation.value();
            System.out.println(value);
            String[] strings = annotation.value2();
            System.out.println(Arrays.toString(strings));
        }

        Method show = clazz.getMethod("show");
        MyAnnotation annotation1 = show.getAnnotation(MyAnnotation.class);
        if (annotation1 !=null){
            String value = annotation1.value();
            System.out.println(value);
            String[] strings = annotation1.value2();
            System.out.println(Arrays.toString(strings));
        }
    }
}

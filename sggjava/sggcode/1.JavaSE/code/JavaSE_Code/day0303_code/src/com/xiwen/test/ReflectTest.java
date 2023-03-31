package com.xiwen.test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-9:39
 * @Version: 1.0
 */
public class ReflectTest {

    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> studentClazz = Class.forName("com.xiwen.test.Student");

        //空参构造器
        Object student = studentClazz.newInstance();
        //获取id
        Field studentClazzField = studentClazz.getDeclaredField("id");
        studentClazzField.setAccessible(true);

        System.out.println("stuId=" + studentClazzField.get(student));

        studentClazzField.set(student, 10000);
        System.out.println("stuId=" + studentClazzField.get(student));


        System.out.println(student);
    }

    @Test
    public void test2() throws Exception {
        Class<?> studentClazz = Class.forName("com.xiwen.test.Student");

        Constructor<?> constructor = studentClazz.getDeclaredConstructor(int.class, String.class, double.class);

        //空参构造器
        Object student = constructor.newInstance(1, "hhh", 200D);
        //获取id
        Field studentClazzField = studentClazz.getDeclaredField("id");
        studentClazzField.setAccessible(true);

        System.out.println("stuId=" + studentClazzField.get(student));

        studentClazzField.set(student, 10000);
        System.out.println("stuId=" + studentClazzField.get(student));


        System.out.println(student);

    }

    @Test
    public void test3() throws Exception {
        Class<?> studentClazz = Class.forName("com.xiwen.test.Student");

        Student o = (Student) studentClazz.newInstance();

        System.out.println("包名:" + studentClazz.getPackage().getName());
        System.out.println("父类名:" + studentClazz.getSuperclass());
        System.out.println("父接口名:" + Arrays.toString(studentClazz.getInterfaces()));
        System.out.println("构造器们:" + Arrays.toString(studentClazz.getDeclaredConstructors()));
        System.out.println("方法们:" + Arrays.toString(studentClazz.getDeclaredMethods()));
        System.out.println("变量们:" + Arrays.toString(studentClazz.getDeclaredFields()));

        Method method = studentClazz.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);
        System.out.println(method.invoke(o, "测试一下"));

        System.out.println(o);
        System.out.println(method.getDeclaringClass());
        System.out.println(method.getReturnType());
        System.out.println(Arrays.toString(method.getParameterTypes()));
        System.out.println(o.getName());

        Method aVoid = studentClazz.getDeclaredMethod("aVoid");
        System.out.println(aVoid.invoke(null));
        System.out.println(aVoid);
    }
}

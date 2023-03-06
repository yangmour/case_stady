package com.xiwen.homework.homework1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-19:05
 * @Version: 1.0
 */
public class AtguiguStudentTest {
    @Test
    public void test1() throws Exception {

        Class<?> clazz = Class.forName("com.xiwen.homework.homework1.AtguiguStudent");

        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("类加载器：" + classLoader);
        System.out.println("包名:" + clazz.getPackage());
        System.out.println("父类名:" + clazz.getSuperclass());
        System.out.println("接口名:" + Arrays.toString(clazz.getInterfaces()));
        System.out.println("属性名:" + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("构造器名:" + Arrays.toString(clazz.getDeclaredConstructors()));
        System.out.println("方法名:" + Arrays.toString(clazz.getDeclaredMethods()));


    }

    @Test
    public void test3() throws Exception {
        Class<?> clazz = Class.forName("com.xiwen.homework.homework1.AtguiguStudent");

        Object o = clazz.newInstance();
        Field school = clazz.getDeclaredField("school");
        school.setAccessible(true);
        school.set(o, "尚硅谷");
        System.out.println(school.get(o));
        System.out.println(o);
    }

    @Test
    public void test4() throws Exception {
        Class<?> clazz = Class.forName("com.xiwen.homework.homework1.AtguiguStudent");

        Object o = clazz.newInstance();
        Field school = clazz.getDeclaredField("className");
        school.setAccessible(true);
        school.set(o, "0201");
        System.out.println(school.get(o));
        System.out.println(o);
    }

    @Test
    public void test5() throws Exception {
        Class<?> clazz1 = Class.forName("com.xiwen.homework.homework1.AtguiguStudent");
        Class<?> clazz2 = Class.forName("com.xiwen.homework.homework1.AtguiguStudent");


        Field school = clazz1.getDeclaredField("school");
        school.setAccessible(true);
        school.set(null, "尚硅谷");

        AtguiguStudent o1 = (AtguiguStudent) clazz1.newInstance();
        Field className1 = clazz1.getDeclaredField("className");
        className1.setAccessible(true);
        className1.set(o1, "0201");

        AtguiguStudent o2 = (AtguiguStudent) clazz2.newInstance();
        Field className2 = clazz2.getDeclaredField("className");
        className2.setAccessible(true);
        className2.set(o2, "0203");


        if (o1.compareTo(o2) > 0) {
            System.out.println("o1大于o2");
        } else if (o1.compareTo(o2) < 0) {
            System.out.println("o2大于o1");

        } else {
            System.out.println("相等！");
        }

    }
}


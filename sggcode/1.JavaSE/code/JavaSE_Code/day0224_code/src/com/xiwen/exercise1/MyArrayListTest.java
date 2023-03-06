package com.xiwen.exercise1;

import org.junit.Test;

import java.util.Iterator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/24-11:09
 * @Version: 1.0
 */
public class MyArrayListTest {
    @Test
    public void test() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("hello");
        list.add("world");
        list.add(null);//null当成有效的元素
        list.add("java");
        list.add("java");
        list.add("java");
        list.add("java");

        System.out.println("原始：");
        Object[] objects = list.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        int nullInndex = list.indexOf(null);
        System.out.println("nullInndex = " + nullInndex);
        int javaIndex = list.indexOf("java");
        System.out.println("javaIndex = " + javaIndex);

        System.out.println("删除[0]位置的元素后：");
        list.remove(0);
        objects = list.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        System.out.println("删除null元素后：");
        list.remove(null);
        objects = list.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    public void test2() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("hello");
        list.add("world");
        list.add(null);//null当成有效的元素
        list.add("java");

        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test3() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("hello");
        list.add("world");
        list.add(null);//null当成有效的元素
        list.add("java");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("hello");
        list.add("world");
        list.add(null);//null当成有效的元素
        list.add("java");

        System.out.println(list.contains("hello"));
        list.set(1,"hhhh");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

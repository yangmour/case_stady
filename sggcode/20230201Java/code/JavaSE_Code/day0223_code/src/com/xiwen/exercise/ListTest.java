package com.xiwen.exercise;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/23-11:11
 * @Version: 1.0
 */
public class ListTest {
    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        ArrayList<String> newList = new ArrayList<>();
        newList.add("abc");
        newList.add("def");
        newList.add("aaa");
        newList.add("456");
        newList.add("789");

        list.addAll(1, newList);

        String remove = list.remove(2);
        System.out.println(remove);

        ArrayList<String> removeList = new ArrayList<>();
        removeList.add("aaa");
        removeList.add("abc");
        boolean b = list.removeAll(removeList);
        System.out.println(b);

//        list.removeIf(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.contains("789");
//            }
//        });

//        list.set(2, "abc");

        System.out.println(list);

        List<String> strings = list.subList(2, 4);
        System.out.println(strings);

//        int abc = list.indexOf("abc");
//        String s = list.get(abc);
//        System.out.println(s);
//
//        list.replaceAll(new UnaryOperator<String>() {
//            @Override
//            public String apply(String s) {
//                return "abc".equals(s) ? "bbb":s;
//            }
//        });
//
//        System.out.println(list);


    }

    @Test
    public void test2() {

        ArrayList<String> list = new ArrayList<>();

        list.add("123");
        list.add("456");
        list.add("789");
        list.add("abc");
        list.add("def");
        list.add("aaa");
        System.out.println(list);

        List<String> strings = list.subList(1, 4);
        System.out.println(strings);
    }
}

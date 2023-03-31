package com.xiwen.exercise;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/23-14:29
 * @Version: 1.0
 */
public class SetTest {
    @Test
    public void test1() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("abc");
        hashSet.add("def");
        hashSet.add("aaa");
        hashSet.add("456");
        hashSet.add("789");

        System.out.println(hashSet);


        int size = hashSet.size();//map的size值

        //逐个变量这个添加的set然后add添加
        hashSet.addAll(hashSet);
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("abc");
        hashSet2.add("def");
        hashSet2.add("aaa");
        hashSet2.add("456");
        hashSet.removeAll(hashSet2);
        System.out.println(hashSet);

    }


    @Test
    public void test2() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("abc");
        linkedHashSet.add("def");
        linkedHashSet.add("aaa");
        linkedHashSet.add("456");
        linkedHashSet.add("789");

        System.out.println(linkedHashSet);

        boolean abc = linkedHashSet.contains("abc");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("abc");
        treeSet.add("def");
        treeSet.add("aaa");
        treeSet.add("456");
        treeSet.add("789");
        System.out.println(treeSet);
    }

}

package com.xiwen.exercise.exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-10:01
 * @Version: 1.0
 */
public class Exercise1 {
    public static void main(String[] args) {
        //（1）创建一个Collection集合（暂时创建ArrayList集合对象），并指定泛型为<String>
        Collection<String> collection = new ArrayList<>();
        //（2）添加如下单词到集合中，
        //hello,java,world,atguigu,love,you,mom,dad,noon
        collection.add("hello");
        collection.add("java");
        collection.add("world");
        collection.add("atguigu");
        collection.add("love");
        collection.add("you");
        collection.add("mom");
        collection.add("dad");
        collection.add("noon");
        //（3）使用foreach遍历输出，
        for (String s : collection) {
            System.out.print(s + " ");
        }
        System.out.println();
        //（4）使用集合的removeIf方法删除回文单词，为Predicate接口指定泛型<String>
        collection.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                StringBuilder reverse = new StringBuilder(s).reverse();
                return s.equals(reverse.toString());
            }
        });
        //（5）再使用Iterator迭代器输出剩下的单词以及单词的长度，为Iterator接口指定泛型<String>。
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.print(next + "," + "单词长度" + next.length() + "\n");
        }
    }
}

package com.xiwen.homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/21-18:27
 * @Version: 1.0
 */
public class Homework5 {
    public static void main(String[] args) {
        //随机产生几个100以内的偶数，存放到HashSet中
        // ，并且使用Iterator迭代器遍历显示它们，保证最后Set中有10个元素。
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        for (int i = 1; i <= 10; ) {
            int r = random.nextInt(100);
            if (r % 2 == 0 && !(set.contains(r))) {
                set.add(r);
                i++;
            }
        }

        System.out.println("set个数:" + set.size());
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.print(next + " ");
        }

    }
}

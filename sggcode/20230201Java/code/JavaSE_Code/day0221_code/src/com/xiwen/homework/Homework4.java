package com.xiwen.homework;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/21-18:22
 * @Version: 1.0
 */
public class Homework4 {
    public static void main(String[] args) {
        //    随机产生10个100以内的偶数，存放到一个Set集合中
        //    ，然后获取元素的个数，最后使用foreach循环遍历显示它们。

        Set<Integer> set = new LinkedHashSet<>();
        Random random = new Random();
        for (int i = 1; i <= 10; ) {
            int r = random.nextInt(100);
            if (r % 2 == 0 && !(set.contains(r))) {
                set.add(r);
                i++;
            }
        }
        System.out.println("set个数:" + set.size());
        for (Integer integer : set) {
            System.out.print(integer + " ");
        }


    }

}

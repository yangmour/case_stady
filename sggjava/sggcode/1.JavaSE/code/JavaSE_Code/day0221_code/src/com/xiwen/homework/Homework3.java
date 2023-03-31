package com.xiwen.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/21-18:36
 * @Version: 1.0
 */
public class Homework3 {
    public static void main(String[] args) {

        List list = new ArrayList();
        Random random = new Random();
        for (int i = 1; i <= 10; ) {
            int r = random.nextInt(20);
            if (r % 2 == 0 && !(list.contains(r))) {
                list.add(r);
                i++;
            }
        }

        System.out.println("元素的个数:" + list.size());
        System.out.println("从前往后遍历");
        for (Object o : list) {
            System.out.print(o + " ");
        }

        System.out.println("从后向前遍历");
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }

        int i = list.indexOf(12);

        for (; i < list.size(); i++) {
            list.remove(i);
        }

    }
}

package com.xiwen.exercise.exercise1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/21-15:06
 * @Version: 1.0
 */
public class Exercise2Test {
    @Test
    public void test() {
        /**
         * （1）创建一个Collection集合primeNumbers（暂时new ArrayList())
         * （2）添加100以内的质数到primeNumbers集合中
         * 提示：质数是大于1的自然数，并且只能被1和它本身整除。
         * （3）查看100以内的质数个数有几个
         * （4）使用foreach遍历primeNumbers集合中的所有质数。
         * （5）使用Iterator迭代器删除个位数是3的质数。
         * （6）判断primeNumbers集合中是否有11，如果有请使用Collection集合的remove方法删除11。
         * （7）使用Collection集合的removeIf方法删除个位数是7的质数。
         * （8）再次使用Iterator遍历primeNumbers集合中剩下的质数。
         * （9）创建另一个Collection集合randNumbers
         * （10）添加10个100以内的随机整数到randNumbers集合中
         * （11）使用foreach遍历randNumbers集合中的随机数。
         * （12）求它们的交集
         */

        Collection primeNumbers = new ArrayList();

        System.out.println("(2)小题");
        for (int i = 2; i < 100; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primeNumbers.add(i);
            }
        }

        for (Object primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
        System.out.println();
        System.out.println("(3)小题");
        System.out.println("质数有:" + primeNumbers.size());

        System.out.println("(4)小题");
        for (Object primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
        System.out.println();
        System.out.println("(5)小题");
        //第一种
//        Iterator iterator = primeNumbers.iterator();
//        while (iterator.hasNext()) {
//            int num = (int) iterator.next();
//            if (num % 10 == 3) {
//                iterator.remove();
//            }
//        }
//        System.out.println("删除结果:");
//        for (Object primeNumber : primeNumbers) {
//            System.out.print(primeNumber + " ");
//        }
//        System.out.println();
        //第二种
        primeNumbers.removeIf(new Predicate() {
            @Override
            public boolean test(Object o) {
                int num = (int) o;
                if (num % 10 == 3) {
                    return true;
                }
                return false;
            }
        });

        System.out.println("删除结果:");
        for (Object primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
        System.out.println();

        System.out.println("(6)小题");
        //第一种
        Iterator iterator = primeNumbers.iterator();
        while (iterator.hasNext()) {
            int num = (int) iterator.next();
            if (num == 11) {
                iterator.remove();
            }
        }
        System.out.println("删除结果:");
        for (Object primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
        System.out.println();

        //第二种
//        primeNumbers.removeIf(new Predicate() {
//            @Override
//            public boolean test(Object o) {
//                int num = (int) o;
//                if (num == 11) {
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        System.out.println("删除结果:");
//        for (Object primeNumber : primeNumbers) {
//            System.out.print(primeNumber + " ");
//        }
//        System.out.println();


        /**
         *（7）使用Collection集合的removeIf方法删除个位数是7的质数。
         *（8）再次使用Iterator遍历primeNumbers集合中剩下的质数。
         *（9）创建另一个Collection集合randNumbers
         *（10）添加10个100以内的随机整数到randNumbers集合中
         *（11）使用foreach遍历randNumbers集合中的随机数。
         *（12）求它们的交集
         */
        System.out.println("(7)小题");
        primeNumbers.removeIf(o -> {
            int num = (int) o;
            if (num % 10 == 7) {
                return true;
            }
            return false;
        });
        System.out.println("(8)小题");
        System.out.println("删除结果:");
        for (Object primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
        System.out.println();

        System.out.println("(9-11)小题");
        Collection randNumbers = new ArrayList();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int r = random.nextInt(100);
            randNumbers.add(r);

        }
        for (Object randNumber : randNumbers) {
            System.out.print(randNumber + " ");
        }
        System.out.println();


        System.out.println("(12)小题");

        primeNumbers.retainAll(randNumbers);
        System.out.println("交集结果:");
        for (Object primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
        System.out.println();


    }

}



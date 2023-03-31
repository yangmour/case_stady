package com.xiwen.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-15:31
 * @Version: 1.0
 */
public class Exercise1 {
    public static void main(String[] args) {
        //1、打印1-100之间的偶数
        long start = System.currentTimeMillis();
        for (int i = 2; i <= 100; i += 2) {
            System.out.print(i + (i % 5 == 0 ? "\n" : "\t"));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println("--------------");


        start = System.currentTimeMillis();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println("--------------");
        start = System.currentTimeMillis();
        for (int i = 2; i <= 100; i += 2) {
            System.out.println(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);


    }
}

package com.xiwen.exercise2;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-16:44
 * @Version: 1.0
 */
public class Exercise4 {
    public static void main(String[] args) {
        //4、输入两个正整数m和n，求其最大公约数和最小公倍数
        Scanner scanner = new Scanner(System.in);
        while (true) {

            int m;
            int n;
            do {
                System.out.println("请输入一个正整数:");
                m = scanner.nextInt();
                System.out.println("请输入一个正整数:");
                n = scanner.nextInt();
            } while (m < 0 || n < 0);


            int max = m > n ? m : n;
            int min = m < n ? m : n;

            for (int i = min; i > 0; i--) {
                if (min % i == 0 && max % i == 0) {
                    System.out.println("最大公约数为:" + i);
                    System.out.println("最小公倍数为:" + m * n / i);
                    break;
                }
            }

            for (int i = max; i <= m * n; i++) {
                if (i % max == 0 && i % min == 0) {
                    System.out.println("最小公倍数为:" + i);
                    break;
                }
            }
        }


    }
}

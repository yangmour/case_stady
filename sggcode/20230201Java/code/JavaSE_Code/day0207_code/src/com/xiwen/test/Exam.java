package com.xiwen.test;

import org.junit.Test;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-8:37
 * @Version: 1.0
 */
public class Exam {

    public static void main(String[] args) {

        /**
         * 1.使用循环输出"a"到“z” 和大写的a->z
         * 例子：a->A
         *      b->B
         */

        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(i + "->" + (char) (i - 32));
        }


        /**
         * 2.使用if-else 或switch-case实现从键盘输入年份和月份，输出该月天数
         */

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入年份:");
        int year = scanner.nextInt();
        System.out.print("请输入月份:");
        int month = scanner.nextInt();

        int day = 0;
        switch (month) {
            case 1:
                day = 31;
                break;
            case 2:
                day = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
                break;
            case 3:
                day = 31;
                break;
            case 4:
                day = 30;
                break;
            case 5:
                day = 31;
                break;
            case 6:
                day = 30;
                break;
            case 7:
                day = 31;
                break;
            case 8:
                day = 31;
                break;
            case 9:
                day = 30;
                break;
            case 10:
                day = 31;
                break;
            case 11:
                day = 30;
                break;
            case 12:
                day = 31;
                break;
            default:
                System.out.println("输入有误！");
                System.exit(0);
        }

        System.out.println(year + "年" + month + "月有" + day + "天");

    }

    @Test
    public void test(){
        System.out.println(111);
    }
}

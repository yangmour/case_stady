package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-14:52
 * @Version: 1.0
 */
public class ArrayExercise2 {
    public static void main(String[] args) {

        /**
         * （1）用一个数组，保存星期一到星期天的7个英语单词，数组如下：
         * {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}
         * （2）从键盘输入1-7的整数，显示该整数对应的单词
         */

        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入1-7的数字输出星期几:");
        int i = scanner.nextInt();

        if (i <= 0 || i > 7) {
            System.out.println("输入错误！");
        }

        System.out.println(week[i-1]);

    }
}

package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-15:50
 * @Version: 1.0
 */
public class ArrayExercise5 {
    public static void main(String[] args) {
        /**
         * 用一个数组存储本组学员的姓名，先从键盘输入小组人数
         * ，再从键盘输入每一个学员的姓名，然后遍历显示。
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入小组人数:");
        int len = scanner.nextInt();
        String[] group = new String[len];

        for (int i = 0; i < len; i++) {
            System.out.print("请输入第" + (i + 1) + "位姓名:");
            String name = scanner.next();
            group[i] = name;
        }

        for (String name : group) {
            System.out.println(name);
        }

    }
}

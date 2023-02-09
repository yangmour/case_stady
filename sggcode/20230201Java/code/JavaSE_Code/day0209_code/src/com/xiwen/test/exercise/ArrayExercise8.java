package com.xiwen.test.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-9:24
 * @Version: 1.0
 */
public class ArrayExercise8 {
    public static void main(String[] args) {
        /**
         * - 从键盘输入本组学员的人数
         * - 再分别从键盘输入本组学员的姓名和成绩
         * - 找出最高分同学的姓名
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入本组人数:");
        int len = scanner.nextInt();
        int[] scores = new int[len];

        for (int i = 0; i < scores.length; i++) {
            System.out.print("请输入第" + (i + 1) + "个学院的评分:");
            scores[i] = scanner.nextInt();
        }

        int max = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[max]) {
                max = i;
            }
        }

        System.out.println("本组的最高分为:" + scores[max]);

    }
}

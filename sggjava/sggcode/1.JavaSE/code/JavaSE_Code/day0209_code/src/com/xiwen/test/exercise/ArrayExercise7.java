package com.xiwen.test.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-9:13
 * @Version: 1.0
 */
public class ArrayExercise7 {
    public static void main(String[] args) {
        //有10个评委给参加编程比赛的某个选手的作品打分
        // ，从键盘输入10个评委的分数，并存储到一维数组中。
        // 然后求选手的最后得分（去掉一个最高分和一个最低分后其余8位评委打分的平均值）
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入评委人数:");
        int len = scanner.nextInt();
        int[] scores = new int[len];

        for (int i = 0; i < scores.length; i++) {
            System.out.print("请输入第" + (i + 1) + "个评委的评分:");
            scores[i] = scanner.nextInt();
        }

        int max = 0;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > scores[max]) {
                max = i;
            }

            min = scores[i] < scores[min] ? i : min;
            sum += scores[i];
        }

        System.out.println("max = " + scores[max]);
        System.out.println("min = " + scores[min]);
        System.out.println("平均分为:" + (double) (sum - scores[max] - scores[min]) / (scores.length - 2));

    }
}

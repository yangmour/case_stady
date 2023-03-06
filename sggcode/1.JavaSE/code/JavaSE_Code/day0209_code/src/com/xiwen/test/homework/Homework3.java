package com.xiwen.test.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-19:00
 * @Version: 1.0
 */
public class Homework3 {

    public static void main(String[] args) {
        /**
         * 案例需求：先从键盘输入本组学员的人数，再从键盘输入本组学员的姓名和成绩，显示学员姓名和成绩。
         * 最后查找是否有满分(100)学员，如果有显示姓名，否则显示没有满分学员。
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入本组的学员人数:");
        int len = scanner.nextInt();
        int[] scores = new int[len];
        String[] names = new String[len];
        for (int i = 0; i < scores.length; i++) {
            System.out.print("请输入第" + (i + 1) + "个学员的姓名:");
            names[i] = scanner.next();
            System.out.print("请输入第" + (i + 1) + "个学员的分数:");
            scores[i] = scanner.nextInt();
        }

        for (int i = 0; i < scores.length; i++) {
            System.out.println("姓名:" + names[i] + "分数为:" + scores[i]);
        }

        for (int i = 1; i < scores.length; i++) {
            boolean flag = true;
            for (int j = 0; j < scores.length - 1; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;

                    String tempStr = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempStr;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

        }

        int left = 0;
        int right = len - 1;
        int target = 100;
        int index = -1;
        while (left <= right || scores[left] > target || scores[right] < target) {
            int mid = left + (right - left) / 2;
            if (target == scores[mid]) {
                index = mid;
                break;
            } else if (target < scores[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }

        if (index == -1) {
            System.out.println("没有满分的同学!");
        } else {
            System.out.println("满分的同学姓名:" + names[index]);
        }

    }


}

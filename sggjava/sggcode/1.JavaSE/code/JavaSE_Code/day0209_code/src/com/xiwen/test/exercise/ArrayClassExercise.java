package com.xiwen.test.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-16:29
 * @Version: 1.0
 */
public class ArrayClassExercise {
    public static void main(String[] args) {
        /**
         使用二维数组：
         （1）从键盘输入本班的小组总数
         （2）再分别输入每一个小组的人数
         （3）然后输入每一个小组每一个人的成绩
         （4）遍历显示所有同学的成绩
         （5）找出每一个小组的最高分，最低分，平均分
         （6）找出全班的最高分，最低分，平均分
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入本班小组的总数:");
        int group = scanner.nextInt();
        int[][] student = new int[group][];

        int[] propers = new int[group];
        int properCount = 0;
        for (int i = 0; i < group; i++) {
            System.out.print("请输入本班第" + (i + 1) + "个小组的人数:");
            int proper = scanner.nextInt();
            student[i] = new int[proper];

            propers[i] = proper;
            properCount += proper;

            for (int j = 0; j < student[i].length; j++) {
                System.out.print("请输入本班第" + (i + 1) + "个小组的第" + (j + 1) + "人的分数:");
                int score = scanner.nextInt();
                student[i][j] = score;
            }

        }


        double[] groupSum = new double[group];
        int[] groupMax = new int[group];
        int[] groupMin = new int[group];


        double classSum = 0;
        int classMax = student[0][0];
        int classMin = student[0][0];

        for (int i = 0; i < group; i++) {
            groupMin[i] = student[i][0];
            groupMax[i] = student[i][0];
            System.out.println("第" + (i + 1) + "组:");
            for (int j = 0; j < student[i].length; j++) {
                System.out.println("第" + (j + 1) + "个人的成绩为:" + student[i][j]);
                if (groupMax[i] < student[i][j]) {
                    groupMax[i] = student[i][j];
                } else if (groupMin[i] > student[i][j]) {
                    groupMin[i] = student[i][j];
                }

                if (j < student[i].length - 1 && student[i][j + 1] > classMax) {
                    classMax = student[i][j + 1];
                } else if (j < student[i].length - 1 && student[i][j + 1] < classMin) {
                    classMin = student[i][j];
                }

                groupSum[i] += student[i][j];
            }

            classSum += groupSum[i];

            System.out.println("第" + (i + 1) + "组的最高分:" + groupMax[i] + ",最低分为:" + groupMin[i] + ",平均分为:" + groupSum[i] / propers[i]);
            System.out.println("--------------------");

        }

        System.out.println("全班最高分为:" + classMax + ",最低分为:" + classMin + ",平均分为:" + classSum / properCount);

    }
}

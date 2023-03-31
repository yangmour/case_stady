package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-9:08
 * @Version: 1.0
 */
public class Exercise5 {
    public static void main(String[] args) {

        /**
         * 5、岳小鹏参加Java考试，成绩在[0,100]之间，他和父亲岳不群达成承诺：如果：
         * 当成绩为100分时，奖励一辆BMW；
         * 当成绩为[80，99]分时，奖励一台外星人笔记本；
         * 当成绩为[60,80)分时，奖励一部华为手机最新款；
         * 当成绩低于60分时，什么奖励也没有。
         * 请从键盘输入岳小鹏的期末成绩，并加以判断。
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入岳小鹏的成绩:");
        double score = scanner.nextDouble();
        if (score < 0 || score > 100) {
            System.out.println("成绩输入错误！");
        } else if (score == 100) {
            System.out.println("奖励一辆BMW!");
        } else if (score >= 80) {
            System.out.println("奖励一台外星人笔记本!");
        } else if (score >= 60) {
            System.out.println("奖励一部华为手机最新款!");
        } else {
            System.out.println("什么奖励也没有");
        }


    }
}

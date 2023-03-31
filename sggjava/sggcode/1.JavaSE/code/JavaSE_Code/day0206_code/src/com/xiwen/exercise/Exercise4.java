package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-9:05
 * @Version: 1.0
 */
public class Exercise4 {
    public static void main(String[] args) {
        //4、从键盘输入一个分数，如果成绩在[0,100]之间，就显示成绩值，否则就显示输入成绩错误！
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个分数:");
        double score = scanner.nextDouble();
        if (score < 0 || score > 100) {
            System.out.println("成绩输入错误！");
        } else {
            System.out.println("成绩为:" + score);
        }
    }
}

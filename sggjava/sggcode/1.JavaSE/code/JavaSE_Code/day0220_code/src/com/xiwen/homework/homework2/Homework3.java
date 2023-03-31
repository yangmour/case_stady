package com.xiwen.homework.homework2;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-19:01
 * @Version: 1.0
 */
public class Homework3 {
    public static void main(String[] args) {
        //案例需求：
        //* 键盘录入一个源字符串存储在srcStr变量中，再录入要删除的字符串存储在delStr变量中。
        //* 删除该字srcStr符串中的所有delStr字符串。
        //* 并且统计delStr字符串在srcStr中出现的次数
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入源字符串:");
        String srcStr = scanner.nextLine();
        System.out.print("请输入要删除的字符串:");
        String delStr = scanner.next();

        String res = srcStr.replaceAll(delStr, "");
        System.out.println(res);
        System.out.println("要删除的字符出现次数:" + (srcStr.length() - res.length()) / delStr.length());

    }
}

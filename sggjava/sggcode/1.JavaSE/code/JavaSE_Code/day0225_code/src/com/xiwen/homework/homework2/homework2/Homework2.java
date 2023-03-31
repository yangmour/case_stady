package com.xiwen.homework.homework2.homework2;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-17:15
 * @Version: 1.0
 */
public class Homework2 {
    public static void main(String[] args) {

        //键盘录入一串字符，去掉其中重复字符，打印出不同的那些字符，必须保证顺序。
        // 例如输入：aaaabbbcccddd，打印结果为：abcd。效果如图：
        //提示：LinkedHashSet的使用

        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Character> str = new LinkedHashSet<>();

        System.out.print("请输入字符串");
        char[] chars = scanner.next().toCharArray();
        for (char c : chars) {
            str.add(c);
        }
        System.out.println(str);


    }
}

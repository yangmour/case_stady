package com.xiwen.homework.homework1.homework5;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:06
 * @Version: 1.0
 */
public class Homework5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> strings = new LinkedHashSet<>();
        while (true) {
            System.out.print("请输入单词（stop退出）:");
            String word = scanner.next();
            if ("stop".equals(word)) {
                break;
            }
            String lowerCase = word.toLowerCase();
            strings.add(lowerCase);
        }
        System.out.println(strings);
        strings.forEach(System.out::println);

    }

}

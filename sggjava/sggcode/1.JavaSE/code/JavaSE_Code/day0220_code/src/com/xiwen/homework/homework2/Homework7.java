package com.xiwen.homework.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-19:38
 * @Version: 1.0
 */
public class Homework7 {
    public static void main(String[] args) {
        //案例需求：1个字符串中可能包含a-z中的多个字符，字符也可能重复
        // ，例如：String data = “aabcexmkduyruieiopxzkkkkasdfjxjdsds”;
        // 写一个程序，对于给定一个这样的字符串求出字符串出现次数最多的那个字母以及出现的次数
        // （若次数最多的字母有多个，则全部求出）

        String data = "aabcexmkduyruieiopxzkkkkasdfjxjdsdsbbbb";

        int[] counts = new int[26];
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 97]++;
        }

        int max = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[max] < counts[i]) {
                max = i;
            }
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[max] == counts[i]) {
                System.out.println("次数最多的字符是" + (char) (i + 97) + ",出现次数" + counts[i]);

            }

        }

    }
}

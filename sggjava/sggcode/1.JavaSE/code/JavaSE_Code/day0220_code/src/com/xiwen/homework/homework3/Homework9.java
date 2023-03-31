package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-19:52
 * @Version: 1.0
 */
public class Homework9 {
    public static void main(String[] args) {
        String str = "1、 hellao 2. world 3. java 4.String 5. haha 6、HELLO";
        //案例需求：已知一个字符串内容如下，要求统计出现次数最多的字母及其出现的次数。不区分大小写。
        str = str.replaceAll("[^a-z|A-Z]*", "").toLowerCase();
        System.out.println(str);

        int[] counts = new int[26];
        char[] chars = str.toCharArray();
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

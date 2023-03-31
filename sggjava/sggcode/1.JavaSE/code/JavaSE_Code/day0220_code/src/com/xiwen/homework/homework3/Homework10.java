package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-20:00
 * @Version: 1.0
 */
public class Homework10 {
    public static void main(String[] args) {
        //案例需求：获取一个字符串在另一个字符串中出现的次数。
        // 比如：获取"ab"在 “abababkkcadkabkebfkabkskab”中出现的次数
        String str1 = "ab";
        String str2 = "abababkkcadkabkebfkabkskab";
        System.out.println(str1 + "在" + str2 + "中出现次数:" + count(str1, str2));

    }

    private static int count(String str1, String str2) {
        int count = 0;
        while (true) {
            int indexOf = str2.indexOf(str1);
            if (indexOf != -1) {
                str2 = str2.substring(indexOf + str1.length());
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

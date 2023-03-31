package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-18:22
 * @Version: 1.0
 */
public class Homework8 {
    public static void main(String[] args) {
        String str = "abcd12345cd125se123456789";
        String[] split = str.split("[^\\d*]");

        int maxIndex = 0;
        for (int i = 1; i < split.length; i++) {
            if (split[maxIndex].length() < split[i].length()) {
                maxIndex = i;
            }
        }
        str = split[maxIndex];

        System.out.println("字符串长度:" + str.length());
        System.out.println(str);


    }
}

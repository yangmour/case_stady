package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-18:29
 * @Version: 1.0
 */
public class Homework10 {
    public static void main(String[] args) {
        //面试题：将字符串中指定部分进行反转。比如将“abcdefgho”实现部分反转，结果为”abfedcgho”

        String str = "abcdefgho";
        int start = 2;
        int end = 5;
        String reverse = reverse(str, start, end);
        String reverse2 = reverse2(str, start, end);
        System.out.println(reverse);
        System.out.println(reverse2);


    }

    private static String reverse(String str, int start, int end) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char[] charArray = str.toCharArray();

        for (int i = start, j = end; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }

    private static String reverse2(String str, int start, int end) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String left = str.substring(0, start);
        String right = str.substring(end + 1);
        String mid = str.substring(start, end + 1);

        return left + new StringBuilder(mid).reverse() + right;
    }

}

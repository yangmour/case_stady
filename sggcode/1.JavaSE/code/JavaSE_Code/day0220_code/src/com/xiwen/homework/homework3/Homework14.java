package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-20:34
 * @Version: 1.0
 */
public class Homework14 {
    public static void main(String[] args) {

        /**
         * 案例需求：获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodef“;
         * str2 = "cvhellobnm"，最大相同子串是"hello"。
         *  开发提示：将短的那个串进行长度依次递减的子串与较长的串比较。
         */

        String str = findMaxSubString("abcwerthelloyuiodef", "cvhellobnm");
        System.out.println(str);

    }

    private static String findMaxSubString(String str1, String str2) {
        String res = "";

        String maxStr = str1.length() > str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;

        for (int i = 0; i < maxStr.length(); i++) {
            for (int j = minStr.length(); j >= i; j--) {
                String substring = minStr.substring(i, j);
                if (maxStr.contains(substring)) {
                    if (res.length() < substring.length()) {
                        res = substring;
                    }
                }

            }

        }
        return res;
    }
}

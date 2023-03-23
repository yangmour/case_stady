package com.xiwen.algorithm.kmp;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/23 -17:04
 * @Version: 1.0
 */
public class KMPAlgorithm {
    public static void main(String[] args) {

        String str = "BBA ABCDAB ABCDABCDABDE";
        String subString = "ABCDABD";

        //子串的匹配表
        int[] next = kmpNext(subString);
        System.out.println(Arrays.toString(next));

        int index = kmpSearch(str, subString);
        System.out.println("index = " + index);

    }

    private static int kmpSearch(String str, String subString) {
        //子串的匹配表
        int[] next = kmpNext(subString);
        char[] strCharArray = str.toCharArray();
        char[] subCharArray = subString.toCharArray();

        for (int i = 0, j = 0; i < strCharArray.length; i++) {

            //如果没匹配到就在匹配表中向前查找
            while (j > 0 && strCharArray[i] != subCharArray[j]) {
                j = next[j - 1];
            }

            //相等就加1
            if (strCharArray[i] == subCharArray[j]) {
                j++;
            }
            //如果下标和子串的长度一样就说明匹配完成了
            if (j == subCharArray.length) {
                return i - j + 1;
            }

        }

        return -1;
    }

    /**
     * kmp子串匹配表
     *
     * @param subString 子串
     * @return 返回子串匹配表
     */
    private static int[] kmpNext(String subString) {

        char[] charArray = subString.toCharArray();
        int[] next = new int[charArray.length];

        //当字符串长度为1时匹配表的值也是0，所以下标从1开始
        for (int i = 1, j = 0; i < charArray.length; i++) {
            //考虑不同的情况下就根据匹配表向前寻找相同的，找到了就结束
            while (j > 0 && charArray[i] != charArray[j]) {
                j = next[j - 1];
            }

            //如果字符与后一个相同就相加,后面的i也加1
            if (charArray[i] == charArray[j]) {
                j++;
            }
            //将数据数量添加到匹配表
            next[i] = j;
        }
        return next;
    }

}

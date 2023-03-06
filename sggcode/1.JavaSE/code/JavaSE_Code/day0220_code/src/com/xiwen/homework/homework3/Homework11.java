package com.xiwen.homework.homework3;

import org.junit.Test;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-20:00
 * @Version: 1.0
 */
public class Homework11 {
    public static int binarySearch(int[] intsArray, int des) {

        if (intsArray == null || intsArray.length == 0) {
            return -1;
        }

        int left = 0;
        int right = intsArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (des == intsArray[mid]) {
                return mid;
            } else if (des < intsArray[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;

    }

    public static String replace(String text, String subtext, String replace) {

        while (true) {
            int i = text.indexOf(subtext);
            if (i != -1) {
                text = text.substring(0, i) + replace + text.substring(i + subtext.length());
            } else {
                break;
            }
        }
        return text;


    }


    @Test
    public void test() {
        System.out.print(replace("aabbccbb", "bb", "dd"));
    }
}

package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-19:53
 * @Version: 1.0
 */
public class Homework7 {
    public static void main(String[] args) {

        /**
         * 案例需求：判断某个数组是否属于对称数组，即数组正序遍历和倒序遍历的结果是一样的。例如：
         * 开发提示：循环比较数组首尾对称位置元素是否相同，如果有不同，就不是对称数组，所有对称位置都相等才是对称数组。
         */

        int[] arr = {1, 2, 3, 4, 4, 3, 2, 1};
        boolean flag = true;
        for (int i = 0, j = arr.length-1; i < arr.length; i++, j--) {
            if (arr[i] != arr[j]) {
                flag = false;
                break;
            }
        }

        System.out.println(flag?"对称":"不对称");
    }
}

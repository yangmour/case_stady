package com.xiwen.homework.homework2.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:27
 * @Version: 1.0
 */

public class Homework3 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        MyArrays.method(arr,0,1);
        for (Integer num : arr) {
            System.out.println(num);
        }
    }
}
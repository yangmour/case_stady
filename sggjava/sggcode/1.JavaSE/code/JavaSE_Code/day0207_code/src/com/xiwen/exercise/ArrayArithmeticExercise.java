package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-16:46
 * @Version: 1.0
 */
public class ArrayArithmeticExercise {
    public static void main(String[] args) {
        /*
        数组的算法一：对数组中的元素做统计分析
        求总和、求平均值、判断偶数个数、3的倍数个数、素数的个数等
         */
        //需求：随机产生10个[0,100)的整数
        //（1）遍历显示它们
        //（2）统计这些整数中，偶数、奇数的个数分别有几个
        //（3）统计它们的平均值是多少

        int[] arr = new int[10];

        int prime = 0;
        for (int i = 0; i < arr.length; i++) {
            int r = (int) (Math.random() * 100);
            arr[i] = r;

            //素数 math.sqrt(arr[i]) 或 arr[i]
            boolean flag = true;
            for (int j = 2; j < Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(arr[i]);
                prime++;
            }
        }

        int sum = 0;
        double avg = 0.0;
        int even = 0;
        int odd = 0;
        int three = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));

            if (three % 3 == 0) {
                three++;
            }
            sum += arr[i];
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }


        avg = (double) sum / arr.length;
        System.out.println("\n--------");
        System.out.println("sum=" + sum + ",avg = " + avg + ",even = " + even + ",odd = " + odd + ",three = " + three + ",prime = " + prime);


    }
}

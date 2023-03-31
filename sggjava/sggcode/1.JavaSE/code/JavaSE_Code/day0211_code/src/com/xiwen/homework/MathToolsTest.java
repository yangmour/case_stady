package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-20:45
 * @Version: 1.0
 */
public class MathToolsTest {
    public static void main(String[] args) {

        int[] arr = {-1, 2, 3, 4, 5};

        MathTools mathTools = new MathTools();
        System.out.println((mathTools.isEven(arr)?"都是偶数":"有奇数"));
        System.out.println(mathTools.isPositive(arr)?"都是正数":"有负数");
        System.out.println(mathTools.toArray(arr));

    }
}

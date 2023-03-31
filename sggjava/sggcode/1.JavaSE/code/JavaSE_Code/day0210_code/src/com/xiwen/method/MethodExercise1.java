package com.xiwen.method;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-10:47
 * @Version: 1.0
 */
public class MethodExercise1 {
    public static void main(String[] args) {

        /**
         * ### 1、练习题1：算术运算
         * （1）定义一个add方法，可以实现两个整数求和
         * （2）定义一个subtract方法，可以实现两个整数求差
         * （3）定义一个multiply方法，可以实现两个整数求乘积
         * （4）定义一个divide方法，可以实现两个整数求商
         * （5）定义一个remainder，可以实现两个整数求余数
         * （6）定义一个方法calulate，可以实现两个整数求和、差、乘积、商、余数
         * （7）测试调用，从键盘输入两个整数，调用上面的方法测试
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入a数值:");
        int a = scanner.nextInt();
        System.out.print("请输入b数值:");
        int b = scanner.nextInt();

        double[] result = calulate(a, b);

        System.out.println("求和:" + result[0]);
        System.out.println("求差:" + result[1]);
        System.out.println("求积:" + result[2]);
        System.out.println("求商:" + result[3]);
        System.out.println("求余数:" + result[4]);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        return (double) a / b;
    }

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static double[] calulate(int a, int b) {
        double[] result = new double[5];
        result[0] = add(a, b);
        result[1] = subtract(a, b);
        result[2] = multiply(a, b);
        result[3] = divide(a, b);
        result[4] = remainder(a, b);

        return result;
    }


}

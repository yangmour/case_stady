package com.xiwen.method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-16:43
 * @Version: 1.0
 */
public class MethodExerciseGraphicTools12 {
    public static void main(String[] args) {

        /**
         * （1）声明一个图形工具类GraphicTools，包含两个重载方法
         * - 方法1：double triangleArea(double base, double height),根据底边和高，求三角形面积，
         * - 方法2：double triangleArea(double a, double b, double c),根据三条边，求三角形面积
         * ，根据三角形三边求面积的海伦公式：
         * （2）在测试类的main方法中调用
         */

        double base = 3;
        double height = 4;
        double area = triangleArea(base, height);
        System.out.println("area = " + area);
        double a = 2;
        double b = 2;
        double c = 3;
        double area2 = triangleArea(a, b, c);
        System.out.println("area2 = " + area2);
    }

    private static double triangleArea(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return 0;
    }

    private static double triangleArea(double base, double height) {
        if (base > 0 && height > 0) {
            return (base * height) / 2;
        }
        return 0;
    }
}

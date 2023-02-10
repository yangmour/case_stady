package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-18:25
 * @Version: 1.0
 */
public class HomeWork1 {
    public static void main(String[] args) {

        /**
         * 案例需求：
         * （1）声明如下方法：
         * - boolean isTriangle(double a, double b, double c)：判断是否是一个三角形
         * - boolean isRightTriangle(double a, double b, double c)：判断是否是一个直角三角形
         * - boolean isIsoscelesTriangle(double a, double b, double c)：判断是否是一个等腰三角形
         * - boolean isEquilateralTriangle(double a, double b, double c)：判断是否是一个等边三角形
         * - double area(double a, double b, double c)：根据三条边，用海伦公式求面积
         * - double perimeter(double a, double b, double c)：求周长
         * （2）在测试类的main方法,调用方法测试，三条边的值为3,4,5
         */

        double a = 4, b = 4, c = 4;
        double area = area(a, b, c);
        System.out.println("area = " + area);
        double perimeter = perimeter(a, b, c);
        System.out.println("perimeter = " + perimeter);


    }

    private static boolean isTriangle(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && a + b > c && b + c > a && a + c > b) {
            return true;
        }

        return false;
    }

    private static boolean isDoubleEq(double a, double b) {
        if (a > b) {
            return false;
        } else if (a < b) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isIsoscelesTriangle(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && isDoubleEq(a, b) || isDoubleEq(a, c) || isDoubleEq(b, c)) {
            return true;
        }
        return false;
    }

    private static boolean isEquilateralTriangle(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && isDoubleEq(a, b) && isDoubleEq(a, c)) {
            return true;
        }
        return false;
    }

    private static double area(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return 0;
    }

    private static double perimeter(double a, double b, double c) {
        if (isIsoscelesTriangle(a, b, c)) {
            return 2 * a + b;
        } else if (isEquilateralTriangle(a, b, c)) {
            return 3 * a;
        } else if (isTriangle(a, b, c)) {
            return a + b + c;
        }
        return 0;
    }

    private boolean isRightTriangle(double a, double b, double c) {
        if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            return true;
        }
        return false;
    }

}

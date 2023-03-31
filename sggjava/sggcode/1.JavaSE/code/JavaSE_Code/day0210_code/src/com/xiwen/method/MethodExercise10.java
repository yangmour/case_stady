package com.xiwen.method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-15:26
 * @Version: 1.0
 */
public class MethodExercise10 {
    public static void main(String[] args) {
        /**
         * 1）声明MathTools工具类，包含：
         * - int compare(int a, int b)：比较两个整数大小关系
         * ，如果第一个整数比第二个整数大，则返回正整数，如果第一个整数比第二个整数小，则返回负整数，如果两个整数相等则返回0；
         * - int compare(double a, double b)：比较两个小数大小关系
         * ，如果第一个小数比第二个小数大，则返回正整数，如果第一个小数比第二个小数小，则返回负整数，如果两个小数相等则返回0；
         * - int compare(char a, char b)：比较两个字符大小关系
         * ，如果第一个字符比第二个字符编码值大，则返回正整数，如果第一个字符比第二个字符编码值小，则返回负整数，如果两个字符相等则返回0；
         * （2）在测试类的main方法中调用，分别比较
         */
        int a = 1;
        int b = 2;
        int compareInt = compare(a, b);
        if (compareInt == 0) {
            System.out.println("相等");
        } else if (compareInt == 1) {
            System.out.println("a大于b");
        } else {
            System.out.println("b大于a");
        }

        int compareChar = compare(b, a);
        if (compareChar == 0) {
            System.out.println("相等");
        } else if (compareChar == 1) {
            System.out.println("a大于b");
        } else {
            System.out.println("b大于a");
        }

        int compareDouble = compare(30.00, 20.0);
        if (compareDouble == 0) {
            System.out.println("相等");
        } else if (compareDouble == 1) {
            System.out.println("a大于b");
        } else {
            System.out.println("b大于a");
        }
    }

    private static int compare(int a, int b) {
        return a - b;
    }

    private static int compare(double a, double b) {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int compare(char a, char b) {
        return a - b;
    }
}

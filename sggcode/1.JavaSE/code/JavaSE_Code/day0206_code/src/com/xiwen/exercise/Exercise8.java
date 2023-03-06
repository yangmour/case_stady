package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-10:38
 * @Version: 1.0
 */
public class Exercise8 {
    public static void main(String[] args) {
        /**
         * 8、求ax<sup>2</sup>+bx+c=0方程的根，其中a,b,c分别为函数的参数。
         * 如果a≠0，那么：
         * （1）当b<sup>2</sup>-4ac>0，则一元二次方程有两个实数解：![img](尚硅谷_JavaSE_第3章_流程控制语句_拓展练习（上）_附带参考答案.assets\wps1.jpg)
         * （2）当b<sup>2</sup>-4ac=0，则一元二次方程有一个实数解：![img](尚硅谷_JavaSE_第3章_流程控制语句_拓展练习（上）_附带参考答案.assets\wps2.jpg)
         * （3）当b<sup>2</sup>-4ac<0，则一元二次方程在实数范围内无解；
         * 如果a=0,b≠0，那么一元一次方程有一个解：![img](尚硅谷_JavaSE_第3章_流程控制语句_拓展练习（上）_附带参考答案.assets\wps3.jpg)
         * 如果a=0,b=0，那么参数输入有误，该式子不是方程。
         * 提示1：Math.sqrt(num);  sqrt指平方根
         * 例如：
         * 求x*x-4x+1=0方程的根
         * 求x*x-2x+1=0方程的根
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入三个数！");
        System.out.print("请输入a的数值:");
        double a = scanner.nextDouble();
        System.out.print("请输入b的数值:");
        double b = scanner.nextDouble();
        System.out.print("请输入c的数值:");
        double c = scanner.nextDouble();

        if (a == 0 && b == 0) {
            System.out.println("输入有误");
        } else if (a == 0 && b != 0) {
            double x = -(c / b);
            System.out.println("有一个实数解:" + x);
        } else {
            double discriminant = b * b - 4 * a * c;

            if (discriminant < 0) {
                System.out.println("无解");
            } else if (discriminant == 0) {
                double x = -(b / 2 * a);
                System.out.println("有一个实数解:" + x);
            } else {

                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("有两个个实数解x1 = " + x1 + ",x2 = " + x2);
            }
        }

    }

}

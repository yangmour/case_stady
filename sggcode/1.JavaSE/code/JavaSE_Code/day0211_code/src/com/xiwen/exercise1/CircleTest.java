package com.xiwen.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-11:11
 * @Version: 1.0
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();

        circle1.radius = 1.3;
        circle2.radius = 1.5;

        System.out.println("circle1.radius = " + circle1.radius);
        System.out.println("circle2.radius = " + circle2.radius);

        System.out.println("circle1的周长 = " + 2 * Math.PI * circle1.radius + ",面积为：" + Math.PI * circle1.radius * circle1.radius);
        System.out.println("circle2的周长 = " + 2 * Math.PI * circle2.radius + ",面积为：" + Math.PI * circle2.radius * circle2.radius);
    }
}

package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:16
 * @Version: 1.0
 */
public class BicycleTest {
    public static void main(String[] args) {
        Vehicle monocycle = new Monocycle(1);
        monocycle.drive();
        System.out.println(monocycle);
        Vehicle tricycle = new Tricycle(3);
        tricycle.drive();
        System.out.println(tricycle);
        Vehicle bicycle = new Bicycle(2);
        bicycle.drive();
        System.out.println(bicycle);


    }
}

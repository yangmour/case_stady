package com.xiwen.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-16:48
 * @Version: 1.0
 */
public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        triangle.setBases(3, 4, 5);
//        triangle.setBases(1, 2, 3);

        System.out.println(triangle.getInfo());



    }
}

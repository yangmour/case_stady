package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-16:12
 * @Version: 1.0
 */
public class Triangle extends Graphic {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && a + b > c || a + c > b || c + b > a) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double area() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double perimeter() {

        return a + b + c;
    }

    @Override
    public String toString() {
        return "三角形三边是:" + a + "," + b + "," + c + ",面积是:" + area() + ",周长是:" + perimeter();
    }
}

class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println(triangle);
    }
}

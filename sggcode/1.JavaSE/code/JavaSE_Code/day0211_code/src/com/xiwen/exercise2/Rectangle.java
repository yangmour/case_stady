package com.xiwen.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-15:06
 * @Version: 1.0
 */
public class Rectangle {

    double length;
    double width;

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return (length + width) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "area=" + area() +
                ", perimeter=" + perimeter() +
                '}';
    }
}

package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-15:32
 * @Version: 1.0
 */
public class Rectangle extends Graphic {
    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return (length + width) * 2;
    }

    @Override
    public String toString() {
        return "长:" + length + ",宽:" + width + "," + super.toString();
    }
}

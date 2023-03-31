package com.xiwen.homework.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:16
 * @Version: 1.0
 */
public class Rectangle implements Cloneable{
    private Double length;
    private Double width;

    public Rectangle() {
    }

    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }
}

class RectangleTest{
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10.1, 20.5);

        Rectangle clone = null;
        try {
            clone = rectangle.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(rectangle);
        System.out.println(clone);


    }

}

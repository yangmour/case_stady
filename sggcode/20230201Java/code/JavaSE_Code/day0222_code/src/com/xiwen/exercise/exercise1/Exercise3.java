package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-11:19
 * @Version: 1.0
 */
public class Exercise3 {
    public static void main(String[] args) {
        //（1）声明一个坐标类Coordinate<T>，它有两个属性：x,y，都为T类型，属性私有化
        // ，提供有参构造、get/set方法、重写toString方法。
        //
        //（2）在测试类中，创建两个不同的坐标类对象，分别指定T类型为String和Double，并为x,y赋值，打印对象
        Coordinate<String> stringCoordinate = new Coordinate<>("x", "y");
        System.out.println(stringCoordinate);
        Coordinate<Double> doubleCoordinate = new Coordinate<>(10D, 20D);
        System.out.println(doubleCoordinate);

    }
}

class Coordinate<T> {
    private T x;
    private T y;

    public Coordinate(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate() {
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

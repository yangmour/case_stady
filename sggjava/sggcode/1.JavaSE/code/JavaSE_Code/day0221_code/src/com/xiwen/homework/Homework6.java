package com.xiwen.homework;

import java.util.Set;
import java.util.TreeSet;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/21-18:32
 * @Version: 1.0
 */
public class Homework6 {
    public static void main(String[] args) {
        //（1）声明一个圆Circle类型，包含半径radius属性，属性私有化，提供有参构造，get/set，
        // 重写toString方法，实现Comparable接口
        // ，重写int compareTo(Object t)方法按照半径大小排序
        //（2）存储几个圆对象到TreeSet中，并且遍历显示

        Set treeSet = new TreeSet();
        treeSet.add(new Circle(5));
        treeSet.add(new Circle(1));
        treeSet.add(new Circle(10));
        treeSet.add(new Circle(8));

        treeSet.forEach(System.out::println);

    }
}

class Circle implements Comparable {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return radius - ((Circle) o).getRadius();
    }
}

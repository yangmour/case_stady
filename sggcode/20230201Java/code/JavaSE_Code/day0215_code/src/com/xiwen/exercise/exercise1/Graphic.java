package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-16:28
 * @Version: 1.0
 */
public abstract class Graphic {
    public abstract double area();

    public abstract double perimeter();

    @Override
    public String toString() {
        return "面积:" + area() + ",周长:" + perimeter();
    }
}

package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:09
 * @Version: 1.0
 */
public abstract class Vehicle {
    private int wheels;

    public Vehicle() {
    }

    public Vehicle(int wheels) {
        this.wheels = wheels;
    }

    public abstract void drive();

    @Override
    public String toString() {
        return "轮子的数量:" + wheels;
    }
}

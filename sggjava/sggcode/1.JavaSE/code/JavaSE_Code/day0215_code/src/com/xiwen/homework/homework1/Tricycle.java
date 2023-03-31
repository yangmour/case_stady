package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:15
 * @Version: 1.0
 */
public class Tricycle extends Vehicle{
    public Tricycle() {
    }

    public Tricycle(int wheels) {
        super(wheels);
    }

    @Override
    public void drive() {
        System.out.println("脚踏三轮车，稳稳当当往前走");
    }
}

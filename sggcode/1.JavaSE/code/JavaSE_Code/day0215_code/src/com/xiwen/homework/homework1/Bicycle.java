package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:14
 * @Version: 1.0
 */
public class Bicycle extends Vehicle{
    public Bicycle() {
    }

    public Bicycle(int wheels) {
        super(wheels);
    }

    @Override
    public void drive() {

        System.out.println("脚踏双轮自行车，优哉游哉往前走");

    }
}

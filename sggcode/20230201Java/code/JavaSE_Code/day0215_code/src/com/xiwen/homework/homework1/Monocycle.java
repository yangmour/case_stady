package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:12
 * @Version: 1.0
 */
public class Monocycle extends Vehicle {
    public Monocycle() {
    }

    public Monocycle(int wheels) {
        super(wheels);
    }

    @Override
    public void drive() {
        System.out.println("脚踏独轮车，摇摇摆摆往前走");
    }



}

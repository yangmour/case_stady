package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-11:44
 * @Version: 1.0
 */
public class LiveAbleTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Plant plant = new Plant();

        animal.eat();
        animal.breathe();
        animal.sleep();

        plant.eat();
        plant.breathe();
        plant.sleep();

        LiveAble.drink();

    }
}

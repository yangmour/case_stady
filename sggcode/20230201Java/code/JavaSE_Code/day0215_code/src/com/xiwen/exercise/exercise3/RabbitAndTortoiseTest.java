package com.xiwen.exercise.exercise3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-11:51
 * @Version: 1.0
 */
public class RabbitAndTortoiseTest {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        rabbit.run();
        Tortoise tortoise = new Tortoise();
        tortoise.run();
        tortoise.swim();
    }
}

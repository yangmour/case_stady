package com.xiwen.exercise.exercise3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-11:48
 * @Version: 1.0
 */
public class Tortoise implements Runner,Swimming{
    @Override
    public void run() {
        System.out.println("乌龟跑的快");
    }

    @Override
    public void swim() {
        System.out.println("乌龟游得快");
    }
}

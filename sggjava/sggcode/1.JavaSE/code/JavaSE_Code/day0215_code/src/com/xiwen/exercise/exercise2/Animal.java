package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-11:41
 * @Version: 1.0
 */
public class Animal implements LiveAble{
    @Override
    public void eat() {
        System.out.println("吃东西");
    }

    @Override
    public void breathe() {
        System.out.println("吸入氧气呼出二氧化碳");
    }

    @Override
    public void sleep() {
        System.out.println("躺下闭上眼睛睡觉");
    }
}

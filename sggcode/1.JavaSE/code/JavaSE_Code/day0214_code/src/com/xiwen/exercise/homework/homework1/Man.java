package com.xiwen.exercise.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:41
 * @Version: 1.0
 */
public class Man extends Person {
    public Man(String name, int age, String occupation) {
        super(name, age, occupation);
    }

    public Man() {
    }

    @Override
    public void eat() {
        System.out.println(getName() + "狼吞虎咽的吃饭");
    }
    public void smoke(){
        System.out.println(getName() + "抽烟");
    }
}

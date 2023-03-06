package com.xiwen.homeword.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:45
 * @Version: 1.0
 */
public class Woman extends Person {
    public Woman(String name, int age, String occupation) {
        super(name, age, occupation);
    }

    public Woman() {
    }

    @Override
    public void eat() {
        System.out.println(getName() + "细嚼慢咽吃饭");
    }

    public void makeup() {
        System.out.println(getName() + "化妆");
    }
}

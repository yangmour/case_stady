package com.xiwen.exercise.exercise5;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-11:55
 * @Version: 1.0
 */
interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
    //接口中只有公共的静态的常量，
    //注意坑  接口中是没有普通的成员变量的，
    //只有public static final的公共静态常量，而且修饰符往往都是省略的
    //这里设置坑的细节，一个是修饰符省略，迷惑性，另一个常量名没有大写，误导性
}

class Ball implements Rollable {
    private String name;

    public Ball(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void play() {
//        ball = new Ball("Football");//既然是常量，就不能重新赋值
        System.out.println(ball.getName());
    }
}

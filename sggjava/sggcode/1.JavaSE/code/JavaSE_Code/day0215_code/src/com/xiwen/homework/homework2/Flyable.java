package com.xiwen.homework.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:21
 * @Version: 1.0
 */
public interface Flyable {
    void fly();
}

interface Swimming {
    void swim();
}

abstract class Bird {
    public abstract void eat();
}

class Penguin extends Bird implements Swimming {

    @Override
    public void swim() {
        System.out.println("企鹅吃南极磷虾！");
    }

    @Override
    public void eat() {
        System.out.println("企鹅下海捉虾！");
    }
}

class Swan extends Bird implements Flyable, Swimming {

    @Override
    public void fly() {
        System.out.println("天鹅展翅高飞，天南海北任我游！");
    }

    @Override
    public void swim() {
        System.out.println("天鹅把羽毛洗的锃亮，顺便捉条鱼！");
    }

    @Override
    public void eat() {
        System.out.println("天鹅吃水生植物的根茎和种子、水生昆虫、螺类和小鱼!");
    }
}

class Chicken extends Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("鸡上房揭瓦，满院子乱扑腾!");
    }

    @Override
    public void eat() {
        System.out.println("鸡吃谷子!");
    }
}

class Test {
    public static void main(String[] args) {
        Bird[] birds = new Bird[3];
        birds[0] = new Penguin();
        birds[1] = new Swan();
        birds[2] = new Chicken();

        for (Bird bird : birds) {
            bird.eat();

            if (bird instanceof Flyable){
                ((Flyable) bird).fly();
            }else if (bird instanceof Swimming){
                ((Swimming) bird).swim();
            }

        }


    }
}
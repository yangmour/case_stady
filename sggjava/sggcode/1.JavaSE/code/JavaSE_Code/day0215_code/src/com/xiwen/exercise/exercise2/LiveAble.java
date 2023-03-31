package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-11:40
 * @Version: 1.0
 */
public interface LiveAble {
    static void drink() {
        System.out.println("喝水");
    }

    void eat();

    void breathe();

    default void sleep() {
        System.out.println("静止不动");
    }
}

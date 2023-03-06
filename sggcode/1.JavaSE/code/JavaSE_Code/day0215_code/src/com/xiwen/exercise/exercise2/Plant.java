package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-11:43
 * @Version: 1.0
 */
public class Plant implements LiveAble {
    @Override
    public void eat() {
        System.out.println("吸收营养");
    }

    @Override
    public void breathe() {
        System.out.println("吸入二氧化碳呼出氧气");
    }
}

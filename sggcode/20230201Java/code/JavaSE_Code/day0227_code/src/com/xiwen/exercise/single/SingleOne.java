package com.xiwen.exercise.single;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-18:21
 * @Version: 1.0
 */
public class SingleOne {
    private static SingleOne singleOne = new SingleOne();

    private SingleOne() {
    }

    public static void main(String[] args) {
        SingleOne singleOne1 = SingleOne.getSingleOne();
        SingleOne singleOne2 = SingleOne.getSingleOne();
        System.out.println(singleOne1 == singleOne2);

    }

    public static SingleOne getSingleOne() {
        return singleOne;
    }
}



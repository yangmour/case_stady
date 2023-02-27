package com.xiwen.exercise.single;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-18:32
 * @Version: 1.0
 */
public class SingleThree {

    private static SingleThree singleThree;

    private SingleThree() {
    }

    public static void main(String[] args) {
        SingleThree singleThree1 = SingleThree.getInstance();
        SingleThree singleThree2 = SingleThree.getInstance();
        System.out.println(singleThree1 == singleThree2);

    }

    public static SingleThree getInstance() {
        return Inner.singleThree;
    }

    private static class Inner {
        private static SingleThree singleThree = new SingleThree();
    }
}

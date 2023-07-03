package com.xiwen.juc.day03;

class DataOne {

    //    private Integer number = 0;
    private volatile Integer number = 0;

    public synchronized Integer incr() {
        return ++number;
    }
}

public class VolatileAtomicDemo {

    public static void main(String[] args) {
        /**
         * 验证volatile不具备原子性 需要加锁才行
         */

        DataOne dataOne = new DataOne();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(dataOne.incr());
            }).start();
        }
    }
}
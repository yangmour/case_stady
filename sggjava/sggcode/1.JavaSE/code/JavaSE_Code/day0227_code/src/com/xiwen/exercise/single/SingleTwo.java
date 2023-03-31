package com.xiwen.exercise.single;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-18:23
 * @Version: 1.0
 */
public class SingleTwo {
    static SingleTwo singleTwo1;
    static SingleTwo singleTwo2;
    private static SingleTwo singleTwo;


    private SingleTwo() {
    }

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                singleTwo1 = SingleTwo.getSingleTwo();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                singleTwo2 = SingleTwo.getSingleTwo();
            }
        };
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(singleTwo1);
        System.out.println(singleTwo2);
        System.out.println(singleTwo1 == singleTwo2);

    }

    public synchronized static SingleTwo getSingleTwo() {
        if (singleTwo == null) {
            singleTwo = new SingleTwo();
        }
        return singleTwo;
    }
}

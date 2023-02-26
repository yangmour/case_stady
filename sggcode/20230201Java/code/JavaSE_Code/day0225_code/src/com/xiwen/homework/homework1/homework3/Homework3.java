package com.xiwen.homework.homework1.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-11:50
 * @Version: 1.0
 */
public class Homework3 {

    public static void main(String[] args) {

        Runner.setDistance(30);
        Runner r1 = new Runner("兔子", 100, 10000);
        Runner r2 = new Runner("乌龟", 1000, 1000);

        r1.start();
        r2.start();

        try {
            //等待
            r1.join();
            r2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (r1.isFinished() && r2.isFinished()) {

            if (r1.getTime() < r2.getTime()) {
                System.out.println("兔子赢了");
            } else if (r1.getTime() > r2.getTime()) {
                System.out.println("乌龟赢了");
            } else {
                System.out.println("平局");
            }

        } else if (r1.isFinished() || r2.isFinished()) {
            System.out.println(r1.isFinished() ? "兔子赢" : "乌龟赢！");
        } else {
            System.out.println("乌龟和兔子都没有到达终点");
        }


    }
}

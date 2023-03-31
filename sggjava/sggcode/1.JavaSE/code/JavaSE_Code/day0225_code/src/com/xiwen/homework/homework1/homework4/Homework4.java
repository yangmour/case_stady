package com.xiwen.homework.homework1.homework4;


/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-12:53
 * @Version: 1.0
 */
public class Homework4 {
    public static void main(String[] args) {

        Runner.setDistance(30);
        Runner r1 = new Runner("兔子", 100, 10000);
        Runner r2 = new Runner("乌龟", 1000, 1000);

        r1.start();
        r2.start();

        while (true) {
            //判断只要有一线程死了就判断
            if (!r1.isAlive() || !r2.isAlive()) {
                // 判断是否跑完了
                if (!Runner.isRunFlag()) {
                    System.out.println("比赛结束！");
                    r1.interrupt();
                    r2.interrupt();
                    if (r1.isFinished() && r2.isFinished()) {
                        if (r1.getTime() < r2.getTime()) {
                            System.out.println("兔子赢了");
                        } else if (r1.getTime() > r2.getTime()) {
                            System.out.println("乌龟赢了");
                        } else {
                            System.out.println("平局");
                        }
                    } else if (r2.isFinished()) {
                        System.out.println("乌龟赢了");
                    } else {
                        System.out.println("兔子赢了");

                    }

                } else {
                    System.out.println("乌龟和兔子都没有到达终点");
                }
                break;
            }
        }

    }


}

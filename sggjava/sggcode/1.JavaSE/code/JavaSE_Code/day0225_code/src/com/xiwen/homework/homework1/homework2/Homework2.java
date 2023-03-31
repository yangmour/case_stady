package com.xiwen.homework.homework1.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-11:40
 * @Version: 1.0
 */
public class Homework2 {
    public static void main(String[] args) {


        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {

                Thread thread = new Thread(new ChatThread());
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }


    }
}

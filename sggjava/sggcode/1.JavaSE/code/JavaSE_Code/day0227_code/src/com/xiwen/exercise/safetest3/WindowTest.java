package com.xiwen.exercise.safetest3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-11:58
 * @Version: 1.0
 */
public class WindowTest {
    public static void main(String[] args) {

        Ticker ticker = new Ticker();
        Window w = new Window(ticker);
        Thread t1 = new Thread(w, "1");
        Thread t2 = new Thread(w, "2");
        Thread t3 = new Thread(w, "3");


        t1.start();
        t2.start();
        t3.start();

    }
}

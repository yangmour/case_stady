package com.xiwen.exercise.safetest1;

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
        Window w1 = new Window("窗口1",ticker);
        Window w2 = new Window("窗口2",ticker);
        Window w3 = new Window("窗口3",ticker);

        w1.start();
        w2.start();
        w3.start();

    }
}

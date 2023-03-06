package com.xiwen.exercise.safetest2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-11:54
 * @Version: 1.0
 */
public class Window extends Thread {
    private Ticker ticker;

    public Window(String name, Ticker ticker) {
        super(name);
        this.ticker = ticker;
    }

    @Override
    public void run() {
        while (ticker.getTotal() > 0) {
            ticker.setTotal();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}

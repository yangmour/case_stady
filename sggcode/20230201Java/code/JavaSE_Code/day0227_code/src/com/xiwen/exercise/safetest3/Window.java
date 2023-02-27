package com.xiwen.exercise.safetest3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-11:54
 * @Version: 1.0
 */
public class Window implements Runnable {
    private Ticker ticker;

    public Window(Ticker ticker) {
        this.ticker = ticker;
    }

    @Override
    public void run() {
        while (ticker.getTotal() > 0) {
            synchronized (ticker) {
                if (ticker.getTotal() > 0) {
                    ticker.setTotal();
                }

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}

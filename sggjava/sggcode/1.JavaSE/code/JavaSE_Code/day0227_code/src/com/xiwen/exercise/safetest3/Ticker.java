package com.xiwen.exercise.safetest3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-11:55
 * @Version: 1.0
 */
public class Ticker {
    private int total = 10;

    public Ticker(int total) {
        this.total = total;
    }

    public Ticker() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public synchronized void setTotal() {
        total--;
        System.out.println(Thread.currentThread().getName() + "卖了一张，还剩下" + getTotal() + "张票");
    }
}

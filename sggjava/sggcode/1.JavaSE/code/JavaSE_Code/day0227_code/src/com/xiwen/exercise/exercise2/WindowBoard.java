package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-18:42
 * @Version: 1.0
 */

class WindowBoardTest {
    public static void main(String[] args) {
        WindowBoard windowBoard = new WindowBoard();
        Cook cook = new Cook("厨师1", windowBoard);
        Waiter waiter = new Waiter("服务员1", windowBoard);
        Cook cook2 = new Cook("厨师2", windowBoard);
        Waiter waiter2 = new Waiter("服务员2", windowBoard);


        cook.start();
        waiter.start();
        waiter2.start();
        cook2.start();

    }
}

public class WindowBoard {
    public static final int MAX_VALUE = 10;
    private int num;

    public void put() {
        while (num >= MAX_VALUE) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "制作了一份快餐，现在工作台上有:" + num + "份快餐");
        notifyAll();
    }

    public void get() {
        while (num <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "拿走了一份快餐，现在工作台上有:" + num + "份快餐");
        notifyAll();
    }


}

class Cook extends Thread {
    private WindowBoard windowBoard;

    public Cook(String name, WindowBoard windowBoard) {
        super(name);
        this.windowBoard = windowBoard;
    }

    @Override
    public void run() {
        synchronized (windowBoard) {
            while (true) {
                windowBoard.put();
            }
        }
    }
}

class Waiter extends Thread {
    private WindowBoard windowBoard;

    public Waiter(String name, WindowBoard windowBoard) {
        super(name);
        this.windowBoard = windowBoard;
    }

    @Override
    public void run() {
        synchronized (windowBoard) {
            while (true) {
                windowBoard.get();
            }
        }
    }
}

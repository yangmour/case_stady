package com.xiwen.juc.day02.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/02 -15:48
 * @Version: 1.0
 */

class C implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "->开始线程");
        return 1024;
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 1. **为了防止主线程阻塞，建议get方法放到最后**
         * 2. **只计算一次**，FutureTask会复用之前计算过得结果
         *
         * 如果想打印threadName2的结果，即**不想复用之前的计算结果。怎么办？再创建一个FutureTask对象即可。**
         */
        FutureTask<Integer> task = new FutureTask<>(new C());
        new Thread(task, "C").start();
        new Thread(task, "C2").start();

        System.out.println(task.get());

    }
}

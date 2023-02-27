package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-14:47
 * @Version: 1.0
 */
public class Person extends Thread {
    private SinglePlankBridge singlePlankBridge;

    public Person(String name, SinglePlankBridge singlePlankBridge) {
        super(name);
        this.singlePlankBridge = singlePlankBridge;
    }

    @Override
    public void run() {
        synchronized (singlePlankBridge) {
            singlePlankBridge.pass();
        }
    }
}

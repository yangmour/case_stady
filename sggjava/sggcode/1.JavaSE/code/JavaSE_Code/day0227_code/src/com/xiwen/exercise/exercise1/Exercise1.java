package com.xiwen.exercise.exercise1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-14:40
 * @Version: 1.0
 */
public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "张三", "李四", "王五", "赵六", "钱七");
        SinglePlankBridge singlePlankBridge = new SinglePlankBridge(5);

        for (int i = 1; i <= 5; i++) {
            Person run = new Person(names.remove((int) (Math.random() * names.size())), singlePlankBridge);
            run.start();
        }

    }
}

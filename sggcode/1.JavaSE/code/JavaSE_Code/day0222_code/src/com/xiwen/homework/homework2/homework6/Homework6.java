package com.xiwen.homework.homework2.homework6;

import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:47
 * @Version: 1.0
 */
public class Homework6 {
    public static void main(String[] args) throws IOException {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.println("list[5] = " + list.get(5));
        Object[] objects = list.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}

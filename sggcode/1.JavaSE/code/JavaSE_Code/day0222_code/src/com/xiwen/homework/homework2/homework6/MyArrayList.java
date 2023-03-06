package com.xiwen.homework.homework2.homework6;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:47
 * @Version: 1.0
 */
public class MyArrayList<T> {

    private Object[] all = new Object[4];
    private int total;

    public void add(T t) {
        if (total == all.length) {
            all = Arrays.copyOf(all, all.length << 1);
        }
        all[total++] = t;
    }

    public T get(int index) {
        if (index < 0 || index >= total) {
            throw new IndexOutOfBoundsException();
        }
        return (T) all[index];
    }

    public Object[] toArray() {
        return Arrays.copyOf(all, total);
    }
}

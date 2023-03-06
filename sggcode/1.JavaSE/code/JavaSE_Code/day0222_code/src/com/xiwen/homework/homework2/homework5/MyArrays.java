package com.xiwen.homework.homework2.homework5;

import java.util.Comparator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:32
 * @Version: 1.0
 */
public class MyArrays {

    public static <E extends Comparable<E>> void sort(E[] e) {

        for (int i = 1; i < e.length; i++) {
            boolean flag = true;

            for (int j = 0; j < e.length - i; j++) {
                if (e[j].compareTo(e[j + 1]) > 0) {
                    E temp = e[j];
                    e[j] = e[j + 1];
                    e[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }

    }

    public static <E> void sort(E[] e, Comparator<? super E> comparator) {
        for (int i = 1; i < e.length; i++) {
            boolean flag = true;

            for (int j = 0; j < e.length - i; j++) {
                if (comparator.compare(e[j], e[j + 1]) > 0) {
                    E temp = e[j];
                    e[j] = e[j + 1];
                    e[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }

}

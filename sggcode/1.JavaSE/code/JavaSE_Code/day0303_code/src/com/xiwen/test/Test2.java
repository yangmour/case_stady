package com.xiwen.test;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-8:59
 * @Version: 1.0
 */
public class Test2 {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        String[] str = {"123","aaaa","hhhh"};
        String[] copy = copy(str, 2);
        System.out.println(Arrays.toString(copy));
    }

    public <T> T[] copy(T[] arr, int newLen) throws InstantiationException, IllegalAccessException {

        Class<? extends Object[]> clazz = arr.getClass();
        Class<?> componentType = clazz.getComponentType();
        T[] newT = (T[]) Array.newInstance(componentType, newLen);
        for (int i = 0; i < arr.length && i < newLen; i++) {
            newT[i] = arr[i];
        }
        return newT;
    }
}

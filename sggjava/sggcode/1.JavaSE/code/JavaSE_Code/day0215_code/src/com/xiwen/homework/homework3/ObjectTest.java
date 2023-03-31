package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:36
 * @Version: 1.0
 */
public class ObjectTest {
    public static void main(String[] args) {

        new Object() {
            public void print() {
                System.out.println("尚硅谷！");
            }
        }.print();


    }
}

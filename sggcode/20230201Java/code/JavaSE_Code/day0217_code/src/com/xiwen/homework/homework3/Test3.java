package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:34
 * @Version: 1.0
 */
public class Test3 {
    public static int fun() {
        int result = 5;
        try {
            result = result / 0;
            return result;
        } catch (Exception e) {
            System.out.println("Exception");
            result = -1;
            return result;
        } finally {
            result = 10;
            System.out.println("I am in finally.");
        }
    }

    public static void main(String[] args) {
        int x = fun();//Exception
                      //I am in finally.
        System.out.println(x); //-1
    }
}

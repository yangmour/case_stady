package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:37
 * @Version: 1.0
 */
public class Test4 {
    public static int aMethod(int i) throws Exception {
        try {
            return i / 10;
        } catch (Exception ex) {
            throw new Exception("exception in aMethod");
        } finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        try {
            aMethod(0);  //finally
        } catch (Exception e) {
            System.out.println("exception in main");
        }
    }
}

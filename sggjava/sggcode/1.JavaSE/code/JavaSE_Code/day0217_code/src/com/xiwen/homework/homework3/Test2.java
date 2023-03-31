package com.xiwen.homework.homework3;

import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:34
 * @Version: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        int a = -1;
        try {
            if (a > 0) {
                throw new RuntimeException("");
            } else if (a < 0) {
                throw new IOException("");
            } else {
                return;
            }
        } catch (IOException ioe) {
            System.out.println("IOException");  //IOException
        } catch (Throwable e) {
            System.out.println("Throwable");
        } finally {
            System.out.println("finally");     //finally
        }
    }
}
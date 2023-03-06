package com.xiwen.homework.homework1.homework2;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-11:42
 * @Version: 1.0
 */
public class ChatThread implements Runnable {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("是否结束");
            char c = scanner.next().charAt(0);
            if (c == 'y') {
                break;
            }
        }
        scanner.close();
    }
}

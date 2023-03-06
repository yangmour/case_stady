package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-19:25
 * @Version: 1.0
 */
public class Homework7 {
    @Test
    public void test() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(new FileOutputStream("testIO/words.txt"));
        for (int i = 1; i <= 3; i++) {
            System.out.print("请输入一句话:");
            String next = scanner.next();
            printStream.println(next);
        }


    }

    @Test
    public void test2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("testIO/words.txt"));
        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();
            System.out.println(next);
        }


    }
}

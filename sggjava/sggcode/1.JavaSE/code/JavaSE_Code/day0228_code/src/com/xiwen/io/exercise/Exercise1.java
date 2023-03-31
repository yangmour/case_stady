package com.xiwen.io.exercise;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-16:13
 * @Version: 1.0
 */
public class Exercise1 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        FileOutputStream fileOutputStream = new FileOutputStream("day0228_code/iotest/1.txt", true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "gbk");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        while (true) {
            System.out.print("请输入一句话！");
            String next = scanner.next();
            if ("stop".equalsIgnoreCase(next)) {
                break;
            }
            bufferedWriter.write(next);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        outputStreamWriter.close();
        bufferedOutputStream.close();
        fileOutputStream.close();

    }

    @Test
    public void test1() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("iotest/1.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream, "GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        FileOutputStream fileOutputStream = new FileOutputStream("iotest/2.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            System.out.println(line);
        }

        bufferedReader.close();
        inputStreamReader.close();
        bufferedInputStream.close();
        fileInputStream.close();

        bufferedWriter.close();
        outputStreamWriter.close();
        bufferedOutputStream.close();
        fileOutputStream.close();

    }


}

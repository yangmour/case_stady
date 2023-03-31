package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-19:02
 * @Version: 1.0
 */
public class Homework4 {
    @Test
    public void test() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\sgg\\1.javaSE\\day0228_笔记、代码、视频等\\晚上任务\\尚硅谷-第14章_File类与IO流_homework\\我想对你说.txt"), "GBK"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testIO/柴老师的话.txt"), "UTF-8"));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();

    }
}

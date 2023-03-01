package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-18:56
 * @Version: 1.0
 */
public class Homework3 {
    @Test
    public void test() throws IOException {

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\sgg\\1.javaSE\\day0228_笔记、代码、视频等\\尚硅谷-第14章 File类与IO流\\尚硅谷_柴林燕_JavaSE_第14章_File类与IO流.md"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("testIO/笔记.md"));

        byte[] b = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(b)) != -1) {
            bufferedOutputStream.write(b, 0, len);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();


    }
}

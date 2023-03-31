package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-19:29
 * @Version: 1.0
 */
public class Homework8 {
    @Test
    public void test() throws IOException {
        copyDir(new File("E:\\sgg\\1.javaSE\\day0228_笔记、代码、视频等"), new File("testIO"));
    }

    private void copyDir(File src, File desc) throws IOException {

        if (src.isFile()) {
            File sub = new File(desc, src.getName());
            copy(src, sub);
        } else if (src.isDirectory()) {
            for (File file : src.listFiles()) {
                File sub = new File(desc, src.getName());
                sub.mkdir();
                copyDir(file, sub);
            }
        }

    }

    private void copy(File src, File desc) throws IOException {
        System.out.println(src);
        System.out.println(desc);
        FileInputStream fileInputStream = new FileInputStream(src);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(desc);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] b = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(b)) != -1) {
            bufferedOutputStream.write(b, 0, len);
        }

        bufferedOutputStream.close();
        bufferedInputStream.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}

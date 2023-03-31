package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-20:04
 * @Version: 1.0
 */
public class Homework9 {
    @Test
    public void test() throws IOException {
        copyDir(new File("testIO/day0228_笔记、代码、视频等"), new File("./"));
    }

    private void copyDir(File src, File desc) throws IOException {

        if (src.isFile()) {
            File sub = new File(desc, src.getName());
            copy(src, sub);
            src.delete();
        } else if (src.isDirectory()) {
            for (File file : src.listFiles()) {
                File sub = new File(desc, src.getName());
                sub.mkdir();
                copyDir(file, sub);
                src.delete();
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


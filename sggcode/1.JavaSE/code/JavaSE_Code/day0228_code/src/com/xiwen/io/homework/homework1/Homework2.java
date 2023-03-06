package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-18:42
 * @Version: 1.0
 */
public class Homework2 {
    @Test
    public void test2() throws IOException {
        File file = new File("F:\\cs\\testIO\\a.txt");
        if (!file.isFile()) {
            file.createNewFile();
        }

        System.out.println(file.getName() + "大小" + file.length());
        System.out.println(file.getName() + "绝对路径" + file.getAbsolutePath());
        System.out.println(file.getName() + "父路径" + file.getParent());


        File file1 = new File("F:\\cs\\testIO");
        if (file1.isFile()) {
            System.out.println("是一个文件");
        } else if (file1.isDirectory()) {
            System.out.println("是一个文件夹");
        }

        file.delete();

        File file2 = new File("testIO");
        delete(file2);

    }

    public void delete(File file) {
        File[] files = file.listFiles();
        for (File sub : files) {
            if (sub.isFile()) {
                sub.delete();
            } else if (sub.isDirectory()) {
                delete(sub);
            }
        }
    }
}

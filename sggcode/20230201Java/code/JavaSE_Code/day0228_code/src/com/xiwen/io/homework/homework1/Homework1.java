package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-18:39
 * @Version: 1.0
 */
public class Homework1 {
    @Test
    public void test1() throws IOException {
        File file = new File("F:\\cs\\testIO");
        file.mkdir();
        File f = new File(file.getPath(), "1.txt");
        f.createNewFile();

        new File("testIO").mkdir();
        File f2 = new File("testIO/1.txt");
        f2.createNewFile();
    }
}

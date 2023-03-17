package com.xiwen.test;

import java.io.File;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/17 -15:14
 * @Version: 1.0
 */
public class PathTest {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/static/images";
        File file = new File(path);
        if (!file.exists()){
            boolean mkdirs = file.mkdirs();
        }
        System.out.println(file);

    }
}

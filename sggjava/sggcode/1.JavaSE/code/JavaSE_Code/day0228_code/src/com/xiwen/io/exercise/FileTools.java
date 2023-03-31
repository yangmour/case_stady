package com.xiwen.io.exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-14:54
 * @Version: 1.0
 */
public class FileTools {
    public static void main(String[] args) throws IOException {
        copy(new File("C:\\Users\\xiwen\\Desktop\\JavaSE_Code")
                , new File("F:\\cs"));
    }

    private static void copy(File src, File desc) throws IOException {
        File sub = new File(desc + "\\" + src.getName());
        System.out.println(src.getParent() + "\\" + src.getName() + "复制到！" + src.getParent() + "\\" + sub.getName());
        if (src.isDirectory()) {
            System.out.println(desc.getName() + "\\" + src.getName() + "创建文件夹");
            sub.mkdir();

            System.out.println("遍历当前文件夹" + src);
            File[] files = src.listFiles();
            for (File file : files) {
                copy(file, sub);
            }
        } else if (src.isFile()) {
            System.out.println("开始复制" + src.getName() + "文件！");
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(sub);

            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            System.out.println("复制" + src.getName() + "文件完成！");
        }

    }
}

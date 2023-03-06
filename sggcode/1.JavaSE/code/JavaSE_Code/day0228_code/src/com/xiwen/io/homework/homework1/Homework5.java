package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-19:11
 * @Version: 1.0
 */
public class Homework5 {
    @Test
    public void test() throws Exception {
        int a = 10;
        char c = 'a';
        double d = 2.5;
        boolean b = true;
        String str = "尚硅谷";

        FileOutputStream fileOutputStream = new FileOutputStream("testIO/data.bat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeInt(a);
        objectOutputStream.writeChar(c);
        objectOutputStream.writeDouble(d);
        objectOutputStream.writeBoolean(b);
        objectOutputStream.writeUTF(str);

        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("testIO/data.bat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readUTF());

        objectInputStream.close();
        fileInputStream.close();

    }
}

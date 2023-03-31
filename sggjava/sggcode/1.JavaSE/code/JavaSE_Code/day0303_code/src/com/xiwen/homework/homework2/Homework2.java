package com.xiwen.homework.homework2;

import java.io.InputStream;
import java.util.Properties;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-19:16
 * @Version: 1.0
 */
public class Homework2 {
    public static void main(String[] args) throws Exception {

        InputStream sras = ClassLoader.getSystemResourceAsStream("fruit.properties");

        Properties properties = new Properties();
        properties.load(sras);
        String fruitName = properties.getProperty("fruitName");
        Class<?> clazz = Class.forName(fruitName);
        Fruit o = (Fruit) clazz.newInstance();

        Juicer juicer = new Juicer();
        juicer.run(o);

    }
}

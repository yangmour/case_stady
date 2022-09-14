package com.awen.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    public static void main(String[] args) {
        System.out.println("hello jdbc_1");
    }

    @Test
    public void testConnection1() throws SQLException {
        //方式1
        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:33068/test";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "xiwen123");

        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    @Test
    public void testConnection2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //方式2 迭代方式
        String url = "jdbc:mysql://localhost:33068/test";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "xiwen123");

        //反射获取类信息
        Class classDriver = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) classDriver.newInstance();
        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    @Test
    public void testConnection3() throws Exception {
        //方式3
        String url = "jdbc:mysql://localhost:33068/test";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "xiwen123");

        Class<?> classDriver = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) classDriver.newInstance();

        //注册driver
        DriverManager.registerDriver(driver);
        //获取连接
        Connection connection = DriverManager.getConnection(url, info);

        System.out.println(connection);
    }

    @Test
    public void testConnection4() throws ClassNotFoundException, SQLException {
        //方式5
        String url = "jdbc:mysql://localhost:33068/test";

        //通过反射获取驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*
         * 由于在Driver包中看到
         * static {
         *         try {
         *             java.sql.DriverManager.registerDriver(new Driver());
         *         } catch (SQLException E) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         */

        Connection connection = DriverManager.getConnection(url, "root", "xiwen123");
        System.out.println(connection);
    }

    @Test
    public void testConnection() throws IOException, ClassNotFoundException, SQLException {
        //方式五 最终版

        //类加载器
        InputStream resourceAsStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        //读取流
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

    }

}

package com.xiwen.jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/08 -15:57
 * @Version: 1.0
 */
public class DemoTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("jdbc.properties"));

        Connection conn = DriverManager.getConnection(properties.getProperty("jdbcurl"), properties.getProperty("username"),properties.getProperty("password"));

        System.out.println(conn);
        String sql = "select * from users";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String string1 = resultSet.getString(1);
            String string2 = resultSet.getString(2);
            System.out.println(string1);
            System.out.println(string2);
        }
    }
}
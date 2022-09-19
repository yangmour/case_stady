package com.xiwen1.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    public static Connection getConnection() throws Exception {
        //读取基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        String driverClass = pros.getProperty("driverClass");

        // 加载驱动
        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    public static void closeResource(Connection conn, Statement ps) {

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


}

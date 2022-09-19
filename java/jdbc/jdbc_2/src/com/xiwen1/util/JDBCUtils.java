package com.xiwen1.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
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

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {

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

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    /**
     * druid德鲁伊连接池的获取连接方法
     */
    private static DataSource datasource = null;
    static {
        try {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(is);
            datasource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getDruidConnection() throws Exception {
        return datasource.getConnection();
    }


}

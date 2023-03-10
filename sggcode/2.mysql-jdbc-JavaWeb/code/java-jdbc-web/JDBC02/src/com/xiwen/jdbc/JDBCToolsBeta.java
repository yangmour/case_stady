package com.xiwen.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/10 -10:58
 * @Version: 1.0
 */
public class JDBCToolsBeta {


    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DruidDataSource druidDataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName(properties.getProperty("driverClassName"));
        druidDataSource.setUrl(properties.getProperty("url"));
        druidDataSource.setUsername(properties.getProperty("username"));
        druidDataSource.setPassword(properties.getProperty("password"));
    }

    public static Connection getConnection2() {

        try {
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection1() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("jdbc.properties"));
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet resultSet) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


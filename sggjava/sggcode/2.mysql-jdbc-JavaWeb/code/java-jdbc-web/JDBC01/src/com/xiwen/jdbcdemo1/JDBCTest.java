package com.xiwen.jdbcdemo1;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/08 -11:42
 * @Version: 1.0
 */
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1.反射加载jar包
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.数据库管理连接操作
        String url = "jdbc:mysql://localhost:33068/atguigudb";
        String username = "root";
        String password = "xiwen123";
        Connection conn = DriverManager.getConnection(url, username, password);
//        System.out.println(conn);

        //3.获取一个Statement
        Statement statement = conn.createStatement();
        //4.可以进行增删改操作
        String sql = "insert into emp1 values (10,'jdbc','0')";
        int rows = statement.executeUpdate(sql);
        System.out.println(rows);
        //5.关闭资源
        statement.close();
        conn.close();
    }

    @Test
    public void test1() throws Exception {
        // 1.反射加载jar包
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.数据库管理连接操作
        String url = "jdbc:mysql://localhost:33068/atguigudb";
        String username = "root";
        String password = "xiwen123";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "insert into emp1 values (?,?,?)";

        //3.获取一个PreparedStatement对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, 11);
        preparedStatement.setString(2, "aaaa");
        preparedStatement.setString(3, "男");
        //4.可以进行增删改操作
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows);
        //5.关闭资源
        preparedStatement.close();
        conn.close();
    }


    @Test
    public void test2() throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        Scanner scanner = new Scanner(System.in);
        PreparedStatement preparedStatement = null;

        while (true) {
            System.out.print("输入(1.登陆,2.注册,输入其他退出)");
            int i = scanner.nextInt();
            if (i == 1) {
                System.out.print("请输入用户");
                String username = scanner.next();
                System.out.print("请输入密码");
                String pass = scanner.next();

                if (isLogin(username, pass)) {
                    System.out.println("用户登陆成功！");
                    break;
                } else {
                    System.out.println("用户名或密码错误，登陆失败！");
                }
            } else if (i == 2) {
                System.out.print("请输入用户");
                String username = scanner.next();
                System.out.print("请输入密码");
                String pass = scanner.next();
                System.out.print("请输入名字");
                String name = scanner.next();

                if (isRegister(username)) {
                    System.out.println("用户注册失败,用户已存在！");
                    continue;
                }
                String sql = "insert into users(username,password,name) values (?,?,?)";
                //3.获取一个PreparedStatement对象
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, pass);
                preparedStatement.setString(3, name);
                //4.可以进行增删改操作
                int rows = preparedStatement.executeUpdate();
                System.out.println(rows > 0 ? "注册成功！" : "注册失败！");
            } else {
                System.out.println("退出！");
                break;
            }
        }

        //5.关闭资源
        close(preparedStatement, conn);
    }

    private boolean isLogin(String username, String password) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();

        String sql = "select username,password from users";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String tableUserName = resultSet.getString(1);
            String tablePassword = resultSet.getString(2);
            if (tableUserName.equals(username) && password.equals(tablePassword)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRegister(String username) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();

        String sql = "select username from users where username = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            resultSet.close();
            return true;
        }
        resultSet.close();
        return false;
    }

    private Connection getConn() throws SQLException, ClassNotFoundException {
        // 1.反射加载jar包
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.数据库管理连接操作
        InputStream is = ClassLoader.getSystemResourceAsStream("mysql.properties");
        String url = "jdbc:mysql://localhost:33068/atguigudb";
        String username = "root";
        String password = "xiwen123";

        return DriverManager.getConnection(url, username, password);

    }

    private static void close(PreparedStatement preparedStatement, Connection connection) throws SQLException {

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

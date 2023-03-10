package com.xiwen.dbutils;

import com.xiwen.jdbc.JDBCToolsBeta;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/10 -15:40
 * @Version: 1.0
 */
public class DBUtilsTest {
    @Test
    public void test1() throws SQLException {
        /**
         * 增删改 以增为案例
         */
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCToolsBeta.getConnection();
        String sql = "insert into user_copy values(null,?,?,?)";
        int i = queryRunner.update(connection, sql, "aaa", "aaaqwe", "a");
        System.out.println(i);
        connection.close();

    }

    @Test
    public void test2() throws SQLException {
        /**
         * 获取单个对象
         */
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCToolsBeta.getConnection();
        String sql = "select * from user_copy";
        UserCopy query = queryRunner.query(connection, sql, new BeanHandler<UserCopy>(UserCopy.class));
        System.out.println(query);
        connection.close();
    }

    @Test
    public void test3() throws SQLException {
        /**
         * 获取单个对象
         */
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCToolsBeta.getConnection();
        String sql = "select * from user_copy";
        List<UserCopy> userCopyList = queryRunner.query(connection, sql, new BeanListHandler<>(UserCopy.class));
        userCopyList.stream().forEach(System.out::println);
        connection.close();
    }

    @Test
    public void test4() throws SQLException {
        /**
         * 获取单个结果值
         */
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCToolsBeta.getConnection();
        String sql = "select username from user_copy where id=?";
        Object query = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);
        System.out.println(query);
    }
}

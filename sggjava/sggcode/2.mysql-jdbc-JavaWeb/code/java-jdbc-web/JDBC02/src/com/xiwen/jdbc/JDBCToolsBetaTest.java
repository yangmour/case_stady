package com.xiwen.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/10 -11:03
 * @Version: 1.0
 */
public class JDBCToolsBetaTest {
    public static void main(String[] args) throws SQLException {


        Connection conn = JDBCToolsBeta.getConnection();

        System.out.println(conn);
        String sql = "select * from users";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            String string1 = resultSet.getString(1);
            String string2 = resultSet.getString(2);
            System.out.println(string1);
            System.out.println(string2);
        }

        JDBCToolsBeta.close(conn, ps, resultSet);
    }

    @Test
    public void test1() throws SQLException {
        //批处理5000万条数据插入
        //1.开启mysql批处理参数url加入rewriteBatchedStatements=true
        //2.addBatch
        //3.执行executeBatch
        long start = System.currentTimeMillis();
        Connection conn = JDBCToolsBeta.getConnection();

        System.out.println(conn);
        String sql = "insert into user_copy values (null,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 1; i <= 50000; i++) {
            ps.setString(1, "tom123" + i);
            ps.setString(2, "hhh" + i);
            ps.setString(3, "tom" + i);
            ps.addBatch();

            if (i % 1000 == 0) {
                ps.executeBatch();
            }
        }

        JDBCToolsBeta.close(conn, ps, null);
        long end = System.currentTimeMillis();
        System.out.println(end - start); //1559

    }

    @Test
    public void test2() {
        //批处理5万条数据插入开启事务
        //1.开启mysql批处理参数url加入rewriteBatchedStatements=true
        //2.addBatch
        //3.执行executeBatch
        long start = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCToolsBeta.getConnection();
            conn.setAutoCommit(false);

            System.out.println(conn);
            String sql = "insert into user_copy values (null,?,?,?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 50000; i++) {
                ps.setString(1, "tom123" + i);
                ps.setString(2, "hhh" + i);
                ps.setString(3, "tom" + i);
                ps.addBatch();

                if (i % 1000 == 0) {
                    ps.executeBatch();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null)
                    conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            JDBCToolsBeta.close(conn, ps, null);

        }

        long end = System.currentTimeMillis();
        System.out.println(end - start); //1506

    }

    @Test
    public void test3() {
        // 测试事务
        long start = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCToolsBeta.getConnection();
            conn.setAutoCommit(false);

            System.out.println(conn);
            String sql = "update t_users set salary = ? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "70000");
            ps.setString(2, "2");
            int row = ps.executeUpdate();
            System.out.println(row);

            //模拟报错
            int i = 10 / 0;

            ps.setString(1, "15000");
            ps.setString(2, "1");
            row = ps.executeUpdate();
            System.out.println(row);

        } catch (Exception e) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (conn != null)
                    conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            JDBCToolsBeta.close(conn, ps, null);

        }

        long end = System.currentTimeMillis();
        System.out.println(end - start); //1506

    }

}

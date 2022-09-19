package com.xiwen4.dbutils;

import com.xiwen1.util.JDBCUtils;
import com.xiwen2.dao.bean.Customers;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * @author 希文
 */
public class DbUtilsTest {

    //增删改
    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getDruidConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into Customers(name,email,birth) values(?,?,?)";
        queryRunner.update(conn, sql, "xiwen", "xiwen@126.com", new Date(234523432423L));
        JDBCUtils.closeResource(conn, null);
    }

    //单行数据bean类型
    @Test
    public void test2() throws Exception {
        Connection conn = JDBCUtils.getDruidConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name,email,birth from customers where name = ?";
        ResultSetHandler<Customers> rsh = new BeanHandler<>(Customers.class);
        Customers xiwen = queryRunner.query(conn, sql, rsh, "xiwen");
        System.out.println(xiwen);

    }

    //list方式
    @Test
    public void test3() throws Exception {
        Connection conn = JDBCUtils.getDruidConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id,name,email,birth from customers where id < ?";
        BeanListHandler<Customers> rsh = new BeanListHandler<>(Customers.class);
        List<Customers> xiwen = queryRunner.query(conn, sql, rsh, 10);
        System.out.println(xiwen);

    }

    //map方式
    @Test
    public void test4() throws Exception {
        Connection conn = JDBCUtils.getDruidConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id,name,email,birth from customers where id < ?";
        MapListHandler mapHandler = new MapListHandler();
        List<Map<String, Object>> query = queryRunner.query(conn, sql, mapHandler, 10);
        System.out.println(query);

    }

    //scalarHandler方式处理单一值
    @Test
    public void test5() throws Exception {
        Connection conn = JDBCUtils.getDruidConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select count(*) from customers";

        ScalarHandler scalarHandler = new ScalarHandler<>();
        Object query = queryRunner.query(conn, sql, scalarHandler);
        System.out.println(query);

    }

    //自定义处理
    @Test
    public void test6() throws Exception {
        Connection conn = JDBCUtils.getDruidConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name,email,birth,id from customers where name = ?";
        ResultSetHandler<Customers> rsh = new ResultSetHandler<Customers>() {
            @Override
            public Customers handle(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    Object name = rs.getObject(1);
                    Object email = rs.getObject(2);
                    Date date = rs.getDate(3);
                    Object id = rs.getObject(4);
                    return new Customers(new Integer(String.valueOf(id)), name.toString(), email.toString(), date);
                }

                return null;
            }
        };
        Customers xiwen = queryRunner.query(conn, sql, rsh, "xiwen");
        System.out.println(xiwen);
    }
}

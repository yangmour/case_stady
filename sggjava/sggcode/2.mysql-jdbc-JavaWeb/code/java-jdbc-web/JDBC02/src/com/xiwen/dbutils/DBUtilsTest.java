package com.xiwen.dbutils;

import com.xiwen.jdbc.JDBCToolsBeta;
import com.xiwen.utils.BaseDao;
import com.xiwen.utils.UserDao;
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

    @Test
    public void test5() {
        BaseDao<UserCopy> userCopyBaseDao = new BaseDao<>();
        String sql = "select * from user_copy";
        List<UserCopy> list = userCopyBaseDao.getList(UserCopy.class, sql);
        System.out.println(list);
    }

    @Test
    public void test6() {
        BaseDao<UserCopy> userCopyBaseDao = new BaseDao<>();
        String sql = "select * from user_copy where id =?";
        UserCopy bean = userCopyBaseDao.getBean(UserCopy.class, sql, 1);
        System.out.println(bean);
    }

    @Test
    public void test7() {
        BaseDao<UserCopy> userCopyBaseDao = new BaseDao<>();
        String sql = "select name from user_copy where id =?";
        Object o = userCopyBaseDao.getValue(sql, 1);
        System.out.println(o);
    }

    @Test
    public void test8() {
        UserDao userCopyBaseDao = new UserDao();
        String sql = "select * from user_copy";
        List<UserCopy> list = userCopyBaseDao.getList(sql);
        System.out.println(list);
    }

    @Test
    public void test9() {
        BaseDao dao = new BaseDao();
        String sql = "insert into user_copy values(null,?,?,?)";
        boolean b = dao.update(sql, "BBB", "BBB", "BB");
        System.out.println(b);
    }
}

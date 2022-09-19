package com.awen3.blob;

import com.awen2.Util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 希文
 */
public class BatchInsertTest {


    //方式1是statement

    /**
     * 方式2 prepartstatement 批量操作
     */
    @Test
    public void insertTest1() {
        long s = System.currentTimeMillis();
        
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods values(?,?)";
            ps = conn.prepareStatement(sql);

            for (int i = 1; i <= 50000; i++) {
                ps.setObject(1, i + 1);
                ps.setObject(2,  "xiwen_" + i+1);
                ps.executeUpdate();

            }

            System.out.println("执行成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn, ps);
        }

        long stop = System.currentTimeMillis();
        System.out.println((stop-s));


    }

    /**
     * 方式3 prepartstatement 批量操作
     * addbatch() addexecuteBatch();
     * 让mysql开启批处理的支持。
     * ?rewriteBatchedStatements=true 写在配置文件的url后面
     */
    @Test
    public void insertTest2() {
        long s = System.currentTimeMillis();

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods values(?,?)";
            ps = conn.prepareStatement(sql);

            for (int i = 1; i <= 1000000; i++) {
                ps.setObject(1, i + 1);
                ps.setObject(2,  "xiwen_" + i+1);
                //赞sql
                ps.addBatch();
                if (i%500==0){
                    //执行
                    ps.executeBatch();
                    //清空
                    ps.clearBatch();
                }

            }

            System.out.println("执行成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn, ps);
        }

        long stop = System.currentTimeMillis();
        System.out.println((stop-s));


    }

    /**
     * 方式4 prepartstatement 批量操作
     * addbatch() addexecuteBatch();
     * 使用Connection 的 setAutoCommit(false)  /  commit()
     */
    @Test
    public void insertTest3() {
        long s = System.currentTimeMillis();

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods values(?,?)";
            ps = conn.prepareStatement(sql);

            //设置事务不自动提交
            conn.setAutoCommit(false);

            for (int i = 1; i <= 50000; i++) {
                ps.setObject(1, i + 1);
                ps.setObject(2,  "xiwen_" + i+1);
                //赞sql
                ps.addBatch();
                if (i%500==0){
                    //执行
                    ps.executeBatch();
                    //清空
                    ps.clearBatch();
                }

            }

            System.out.println("执行成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (conn != null) {
                    //执行完毕全部提交
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            JDBCUtils.closeResource(conn, ps);
        }

        long stop = System.currentTimeMillis();
        System.out.println((stop-s));



    }


}

package com.xiwen1.transaction;

import com.xiwen1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }

    /**
     * 假如AA给BB转账200块
     * 如果发网络异常没有考虑事务会发生AA少了200，BB没有多200
     * 考虑事务后要么都执行要么都不执行
     */
    @Test
    public void test2(){
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sqlA = "update user_table set balance = balance - ? where user = ?";
            update(conn,sqlA,200,"AA");

            //假设发生了网络异常
//            int num = 10%0;

            String sqlB = "update user_table set balance = balance + ? where user = ?";
            update(conn,sqlB,200,"BB");
            System.out.println("转账成功");
            //没有发生异常正常结束提交
            conn.commit();
        }catch(Exception e){
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            JDBCUtils.closeResource(conn,null);
        }

    }

    /**
     * 通用更新操作 2.0版本考虑上事务
     * @param sql sql语句
     * @param args sql语句语句中的占位符填充
     * @return  i==0更新失败，i>0 更新成功
     */
    public int update(Connection conn,String sql,Object ... args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps);
        }

        return 0;
    }



}

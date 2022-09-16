package com.awen2.prepartstatement.crud;

import com.awen2.Util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 希文
 */
public class PrepartStatementUpdateTest {



    // 向customers表中添加一条记录
    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
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

            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);

            String sql = "insert into customers(id,name,email,birth) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,20);
            ps.setString(2,"tom");
            ps.setString(3,"tom@126.com");
            ps.setObject(4,"2022-9-16");

            int i = ps.executeUpdate();
            if (i>0){
                System.out.println("插入数据成功！");
            }else{
                System.out.println("插入数据失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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

    // 向customers表中修改一条记录
    @Test
    public void testUpdate2(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "update customers set name=? where id=?";
            ps = conn.prepareStatement(sql);

            ps.setObject(1,"xiwen");
            ps.setObject(2,"20");

            int i = ps.executeUpdate();

            if (i>0){
                System.out.println("数据更新成功！");
            } else {
                System.out.println("数据更新失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }



    }




    }

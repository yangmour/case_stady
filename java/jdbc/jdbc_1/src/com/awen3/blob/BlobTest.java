package com.awen3.blob;

import com.awen2.Util.JDBCUtils;

import com.awen2.bean.Customers;
import org.junit.Test;
import sun.security.krb5.internal.CredentialsUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BlobTest {



    @Test
    public void testInsert(){
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream is=null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into customers(name,email,birth,photo) values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,"周星驰");
            ps.setObject(2,"zhouxingchi@163.com");
            ps.setObject(3,new Date(new java.util.Date().getTime()));

            is = new FileInputStream("你的名字3.png");
            ps.setBlob(4, is);

            int i = ps.executeUpdate();
            if (i>0){
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            JDBCUtils.closeResource(conn,ps);

        }


    }

    @Test
    public void testUpdate(){
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream is = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "update customers set photo=? where name=?";
            ps = conn.prepareStatement(sql);

            is = new FileInputStream("Soldier Lies on the Ground and Patrols the Area From Concealment Opens the Flap of Binoculars Looks by Trzykropy on Envato Elements.mp4");
            ps.setBlob(1,is);
            ps.setObject(2,"周星驰");



            int i = ps.executeUpdate();
            if (i>0){
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            JDBCUtils.closeResource(conn,ps);

        }


    }

    @Test
    public void testQuery(){
        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = null;
        FileOutputStream os = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "select id,name,email,birth,photo from  customers where photo is not null";
            ps = conn.prepareStatement(sql);

//            ps.setObject(1,"not null");

            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<Customers> list = new ArrayList<>();

            while (resultSet.next()){
                Customers customers = new Customers();
                for (int i = 0; i <columnCount ; i++) {

                    Object value = resultSet.getObject(i+1);
                    String columnLabel = metaData.getColumnLabel(i+1);

                    if ("photo".equals(columnLabel)){
                        is = resultSet.getBinaryStream(columnLabel);
                        os = new FileOutputStream(customers.getName());

                        byte[] bytes = new byte[2048];
                        int len;
                        while ((len = is.read(bytes))!=-1){
                            os.write(bytes);
                            System.out.println(len);
                        }
                        break;
                    }


                    Field declaredField = Customers.class.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(customers,value);

                }
                list.add(customers);
            }
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            JDBCUtils.closeResource(conn,ps);

        }


    }

}

package com.awen2.prepartstatement.crud;

import com.awen2.Util.JDBCUtils;
import com.awen2.bean.Customers;
import com.awen2.bean.Order;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrepartstatementQuery {

    //测试通用表查询
    @Test
    public void test1(){
        String sql = "select id,name,birth from customers where id =?";
        Customers customers = getInstance(Customers.class, sql, 16);
        System.out.println(customers);
        String sql2 = "select order_id orderId,order_name orderName from `order` where order_id =?";
        Order order = getInstance(Order.class, sql2, 1);
        System.out.println(order);
    }

    //测试通用表查询多条数据
    @Test
    public void test2(){
        String sql = "select id,name,birth from customers where id <?";
        List<Customers> customersList = getForList(Customers.class, sql, 16);
        customersList.forEach(System.out::println);
        String sql2 = "select order_id orderId,order_name orderName from `order` where order_id <?";
        List<Order> orderList = getForList(Order.class, sql2, 3);
        orderList.forEach(System.out::println);
    }

    public <T> List<T> getForList(Class<T> clazz, String sql, Object...args) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            ResultSet resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<T> list = new ArrayList<>();
            while (resultSet.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object value = resultSet.getObject(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);

                    field.setAccessible(true);
                    field.set(t,value);
                }

                list.add(t);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }


        return null;
    }



    /**
     * 针对不同表的通用查询操作
     * @param clazz
     * @param sql
     * @param args
     * @return
     * @param <T>
     * @throws Exception
     */
    public <T> T getInstance(Class<T> clazz,String sql,Object...args) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            ResultSet resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object value = resultSet.getObject(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);

                    field.setAccessible(true);
                    field.set(t,value);
                }

                return t;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }


        return null;
    }
}

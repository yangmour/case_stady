package com.awen2.prepartstatement.crud;

import com.awen2.Util.JDBCUtils;
import com.awen2.bean.Customers;
import com.awen2.bean.Order;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class OrderForQuery {


    @Test
    public void testQuery2(){
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `Order` where order_id= ?";
        Order order = queryForOrder(sql, 2);
        System.out.println(order);

    }
    /**
     * order表的通用方法
     * @param sql
     * @param args
     * @return
     */
    public Order queryForOrder(String sql,Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //连接操作
            conn = JDBCUtils.getConnection();
            //预处理sql获取preparedStatement
            ps = conn.prepareStatement(sql);

            //将参数放到对应的占位符上
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            //执行语句获取对应数据
            resultSet = ps.executeQuery();

            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取元数据中的列数
            int columnCount = metaData.getColumnCount();
            //判断数据并移动指针
            while (resultSet.next()){
                Order order = new Order();

                //获取当前行的列数据，列数据最大长度根据元数据获取
                for (int i = 0; i < columnCount; i++) {
                    //获取当前列名
                    String columnLabel = metaData.getColumnLabel(i+1);
                    //获取当前列数据
                    Object value = resultSet.getObject(i+1);

                    //通过反射动态的获取当前的列名字
                    Field field = Order.class.getDeclaredField(columnLabel);
                    //赋予权限，属性有可能是私有的
                    field.setAccessible(true);
                    //给类的属性赋值
                    field.set(order,value);
                }

                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,resultSet);
        }

        return null;
    }

    @Test
    public void testQuery1() throws Exception {

        Connection conn = JDBCUtils.getConnection();

        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `Order` where order_id= ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,1);

        ResultSet rs = ps.executeQuery();

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()){
            Order order = new Order();
            for (int i = 0; i < columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i + 1);
                Object value = rs.getObject(i+1);

                Field field = Order.class.getDeclaredField(columnLabel);
                field.setAccessible(true);

                field.set(order,value);
            }
            System.out.println(order);
        }

        JDBCUtils.closeResource(conn,ps,rs);


    }


}

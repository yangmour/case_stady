package com.awen2.prepartstatement.crud;

import com.awen2.Util.JDBCUtils;
import com.awen2.bean.Customers;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author 希文
 */
public class CustomersForQueryTest {


    @Test
    public void testQuery2() {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customers customers = queryForCustomers(sql, 13);
        System.out.println(customers);
        String sql2 = "select id,name,email,birth from customers where name = ?";
        Customers customers2 = queryForCustomers(sql2, "cs");
        System.out.println(customers2);

    }

    /**
     * Customers表的通用查询操作
     *
     * @param sql
     * @param args
     * @return
     * @throws Exception
     */
    public Customers queryForCustomers(String sql, Object... args) {
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
                ps.setObject(i + 1, args[i]);
            }

            //执行语句获取对应数据
            resultSet = ps.executeQuery();

            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取元数据中的列数
            int columnCount = metaData.getColumnCount();
            //判断数据并移动指针
            while (resultSet.next()) {
                Customers customers = new Customers();

                //获取当前行的列数据，列数据最大长度根据元数据获取
                for (int i = 0; i < columnCount; i++) {
                    //获取当前列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //获取当前列数据
                    Object value = resultSet.getObject(i + 1);

                    //通过反射动态的获取当前的列名字
                    Field field = Customers.class.getDeclaredField(columnLabel);
                    //赋予权限，属性有可能是私有的
                    field.setAccessible(true);
                    //给类的属性赋值
                    field.set(customers, value);
                }

                return customers;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null;
    }

    /**
     * customers表的查询操作
     */
    @Test
    public void testQuery1() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select id,name,email,birth from customers where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "cs");

            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }

}

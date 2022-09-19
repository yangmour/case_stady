package com.xiwen2.dao.junit;

import com.xiwen1.util.JDBCUtils;
import com.xiwen2.dao.bean.Customers;
import com.xiwen2.dao.impl.CustomersDaoImpl;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;
public class CustomersDaoImplTest {

    private CustomersDaoImpl customersDao = new CustomersDaoImpl();
    @Test
    public void insert() throws Exception {
        Connection conn = JDBCUtils.getConnection();


        int i = customersDao.insert(conn,new Customers(1,"xiwenya","chenglong@163.com",new Date(1235234235L)));
        System.out.println(i);
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void deleteById() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        int i = customersDao.deleteById(conn, 22);
        System.out.println(i);

    }

    @Test
    public void update() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        int i = customersDao.update(conn, new Customers(22,"xiwen","xiwenya@163.com",new Date(233524235L)));
        System.out.println(i);
    }

    @Test
    public void getCustomersById() {
    }

    @Test
    public void getAll() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        List<Customers> all = customersDao.getAll(conn);
        all.forEach(System.out::println);
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void getCount() {
    }

    @Test
    public void getMaxBirth() {
    }
}
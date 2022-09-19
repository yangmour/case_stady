package com.xiwen3.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.xiwen1.util.JDBCUtils;
import com.xiwen2.dao.bean.Customers;
import com.xiwen2.dao.impl.CustomersDaoImpl;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

public class DruidTest {


    @Test
    public void DruidTest1() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(is);
        DataSource datasource = DruidDataSourceFactory.createDataSource(properties);

        Connection conn = datasource.getConnection();
        System.out.println(conn);
        CustomersDaoImpl customersDao = new CustomersDaoImpl();
        List<Customers> all = customersDao.getAll(conn);
        all.forEach(System.out::println);


    }

    @Test
    public void DruidTest2() throws Exception {
        Connection conn = JDBCUtils.getConnection();

        CustomersDaoImpl customersDao = new CustomersDaoImpl();
        List<Customers> all = customersDao.getAll(conn);
        all.forEach(System.out::println);


    }

    @Test
    public void DruidTest3() throws Exception {
        Connection conn = JDBCUtils.getConnection();

        CustomersDaoImpl customersDao = new CustomersDaoImpl();
        int i = customersDao.deleteById(conn, 20);
        System.out.println(i);


    }





}

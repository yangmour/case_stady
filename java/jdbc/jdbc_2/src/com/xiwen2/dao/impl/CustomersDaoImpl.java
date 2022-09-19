package com.xiwen2.dao.impl;

import com.xiwen2.dao.BaseDao;
import com.xiwen2.dao.CustomersDao;
import com.xiwen2.dao.bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author 希文
 */
public class CustomersDaoImpl extends BaseDao implements CustomersDao {
    @Override
    public int insert(Connection conn, Customers customers) {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        return update(conn, sql,customers.getName(),customers.getEmail(),customers.getBirth());
    }

    @Override
    public int deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        return update(conn, sql,id);
    }

    @Override
    public int update(Connection conn, Customers customers) {
        String sql = "update customers set name=?,email=?,birth=? where id = ?";
        return update(conn, sql,customers.getName(),customers.getEmail(),customers.getBirth(), customers.getId());
    }

    @Override
    public Customers getCustomersById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id =?";
        return getBeanQuery(conn,Customers.class,sql,id);
    }

    @Override
    public List<Customers> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        return getForList(conn,Customers.class,sql);
    }


    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn,sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        return getValue(conn,sql);
    }
}

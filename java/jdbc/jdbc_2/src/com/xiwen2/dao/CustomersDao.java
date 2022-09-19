package com.xiwen2.dao;

import com.xiwen2.dao.bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author 希文
 */
public interface CustomersDao {
    /**
     * 插入一条数据
     * @param conn
     * @param customers
     */
    int insert(Connection conn, Customers customers);

    /**
     * 根据id删除一条数据
     * @param conn
     * @param id
     */
    int deleteById(Connection conn,int id);

    /**
     * 修改一条数据
     * @param conn
     * @param customers
     */
    int update(Connection conn,Customers customers);

    /**
     * 查询指定id的customers
     * @param conn
     * @param id
     */
    Customers getCustomersById(Connection conn,int id);

    /**
     * 查询所有的
     * @param conn
     * @return
     */
    List<Customers> getAll(Connection conn);

    /**
     * 查询总条数
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

    /**
     * 获取最大的生日
     * @param conn
     * @return
     */
    Date getMaxBirth(Connection conn);

}

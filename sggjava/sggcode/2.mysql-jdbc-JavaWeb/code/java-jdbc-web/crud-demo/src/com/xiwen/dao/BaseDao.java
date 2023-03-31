package com.xiwen.dao;


import com.xiwen.utils.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/10 -18:11
 * @Version: 1.0
 */
public abstract class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    public boolean update(String sql, Object... params) {
        /**
         * 增删改 以增为案例
         */
        try {
            int rows = queryRunner.update(JDBCTools.getConnection(), sql, params);
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.close();
        }
        return false;
    }


    private Class<T> clazz;

    //通过当前子类的父类获取泛型参数的类型
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            clazz = (Class<T>) actualTypeArguments[0];
        }

    }

    public List<T> getList(Class<T> clazz, String sql, Object... params) {
        /**
         * 获取多个对象
         */
        try {
            return queryRunner.query(JDBCTools.getConnection(), sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.close();
        }
        return null;
    }

    public List<T> getList(String sql, Object... params) {
        /**
         * 获取多个对象
         */
        return getList(clazz, sql, params);
    }

    public T getBean1(String sql, Object... params) {
        /**
         * 获取单个对象
         */
        try {
            return getList(sql, params).get(0);
        } finally {
            JDBCTools.close();
        }
    }

    public T getBean(String sql, Object... params) {
        return getBean(clazz, sql, params);
    }


    public T getBean(Class<T> clazz, String sql, Object... params) {
        /**
         * 获取单个对象
         */
        try {
            return queryRunner.query(JDBCTools.getConnection(), sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.close();
        }
        return null;
    }

    public Object getValue(String sql, Object... params) {
        /**
         * 获取某个值
         */
        try {
            return queryRunner.query(JDBCTools.getConnection(), sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

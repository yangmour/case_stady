package com.xiwen.dao;

import com.xiwen.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/01 -11:53
 * @Version: 1.0
 */
public class EmployeeDaoTest {


    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession();
    }

    @After
    public void close() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getById() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = employeeDao.getById(1);
        System.out.println(employee);

    }

    @Test
    public void findAll() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        List<Employee> all = employeeDao.findAll();
        all.stream().forEach(System.out::println);
    }

    @Test
    public void getByIdName() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        String name = employeeDao.getByIdName(2);
        System.out.println(name);
    }

    @Test
    public void insert() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee(null, "测试", "cs@163.com", 1, 5000.0, 1);
        int rows = employeeDao.insert(employee);
        System.out.println("rows = " + rows);
    }

    @Test
    public void delete() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        int rows = employeeDao.delete(5);
        System.out.println("rows = " + rows);
    }

    @Test
    public void update() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee(5, "cscscs", "cs@163.com", 1, 5000.0, 1);
        int rows = employeeDao.update(employee);
        System.out.println("rows = " + rows);
    }
}
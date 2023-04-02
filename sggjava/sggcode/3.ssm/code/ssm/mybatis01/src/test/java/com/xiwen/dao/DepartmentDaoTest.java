package com.xiwen.dao;

import com.xiwen.bean.Department;
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
 * @Create: 2023/04/01 -15:30
 * @Version: 1.0
 */
public class DepartmentDaoTest {

    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
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
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        Department department = departmentDao.getById(1);
        System.out.println(department);

    }

    @Test
    public void findAll() {
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        List<Department> all = departmentDao.findAll();
        all.stream().forEach(System.out::println);
    }

    @Test
    public void getByIdName() {
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        String name = departmentDao.getByIdName(2);
        System.out.println(name);
    }

    @Test
    public void insert() {
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        Department department = new Department(6, "cs");
        int rows = departmentDao.insert(department);
        System.out.println("rows = " + rows);
    }

    @Test
    public void delete() {
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        int rows = departmentDao.delete(7);
        System.out.println("rows = " + rows);
    }

    @Test
    public void update() {
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        Department department = new Department(6,"1111");
        int rows = departmentDao.update(department);
        System.out.println("rows = " + rows);
    }
}
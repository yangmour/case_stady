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

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/04 -15:40
 * @Version: 1.0
 */
public class EmployeeDaoTest {
    private SqlSession sqlSession;
    private SqlSessionFactory build;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession();

    }

    @After
    public void close() {
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void getById() {
        SqlSession sqlSession1 = build.openSession();
        EmployeeDao sqlSessionMapper = sqlSession1.getMapper(EmployeeDao.class);
        Employee employee = sqlSessionMapper.getById(1);
        System.out.println(employee);

        SqlSession sqlSession2 = build.openSession();
        EmployeeDao sqlSessionMapper2 = sqlSession2.getMapper(EmployeeDao.class);
        Employee employee2 = sqlSessionMapper2.getById(1);
        System.out.println(employee2);
    }
}
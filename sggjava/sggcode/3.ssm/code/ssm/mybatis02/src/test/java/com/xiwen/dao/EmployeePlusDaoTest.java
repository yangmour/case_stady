package com.xiwen.dao;

import com.xiwen.bean.EmployeePlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/03 -16:19
 * @Version: 1.0
 */
public class EmployeePlusDaoTest {
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
        EmployeePlusDao sqlSessionMapper = sqlSession.getMapper(EmployeePlusDao.class);
        EmployeePlus employeePlus = sqlSessionMapper.getById(2);
        System.out.println(employeePlus);
    }
}
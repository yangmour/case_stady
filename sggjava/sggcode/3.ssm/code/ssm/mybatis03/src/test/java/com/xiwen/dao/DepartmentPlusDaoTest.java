package com.xiwen.dao;

import com.xiwen.bean.DepartmentPlus;
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
 * @Create: 2023/04/04 -13:45
 * @Version: 1.0
 */
public class DepartmentPlusDaoTest {
    private SqlSession sqlSession;

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
        // 联合查询
        DepartmentPlusDao mapper = sqlSession.getMapper(DepartmentPlusDao.class);
        DepartmentPlus departmentPlus = mapper.getById(2);
        System.out.println(departmentPlus.getId() + "," + departmentPlus.getName());
        departmentPlus.getEmps().stream().forEach(System.out::println);
    }
}
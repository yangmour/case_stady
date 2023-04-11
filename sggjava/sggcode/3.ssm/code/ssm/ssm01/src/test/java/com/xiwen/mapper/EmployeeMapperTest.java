package com.xiwen.mapper;

import com.xiwen.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/11 -15:13
 * @Version: 1.0
 */
public class EmployeeMapperTest {

    private SqlSession sqlSession;


    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void getById() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getById(1);
        System.out.println(employee);
    }
}
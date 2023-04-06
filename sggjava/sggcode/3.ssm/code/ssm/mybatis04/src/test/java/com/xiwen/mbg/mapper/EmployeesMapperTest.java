package com.xiwen.mbg.mapper;

import com.xiwen.mbg.bean.Employees;
import com.xiwen.mbg.bean.EmployeesExample;
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
 * @Create: 2023/04/06 -11:52
 * @Version: 1.0
 */
public class EmployeesMapperTest {
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
    public void selectByExample() {
        EmployeesMapper employeesMapper = sqlSession.getMapper(EmployeesMapper.class);

        EmployeesExample employeesExample = new EmployeesExample();
        EmployeesExample.Criteria employeesCriteria = employeesExample.createCriteria();
        //模糊查询带h的
        employeesCriteria.andLastNameLike("%h%");
        //并且大于
        employeesCriteria.andSalaryGreaterThan(4000d);

        EmployeesExample.Criteria employeesCriteriaOr = new EmployeesExample().createCriteria();
        employeesCriteriaOr.andIdLessThan(10);

        //或者小于id10
        employeesExample.or(employeesCriteriaOr);

        List<Employees> employees = employeesMapper.selectByExample(employeesExample);
        employees.stream().forEach(System.out::println);

    }
}
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/04 -15:40
 * @Version: 1.0
 */
public class EmployeeDaoTest {
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
    public void getByMap() {
        EmployeeDao sqlSessionMapper = sqlSession.getMapper(EmployeeDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("lastName", "测");
        map.put("salary", "4000");
//        map.put("gender", 1);
        List<Employee> employees = sqlSessionMapper.getByMap(map);
        employees.stream().forEach(System.out::println);
    }

    @Test
    public void getByMap02() {
        EmployeeDao sqlSessionMapper = sqlSession.getMapper(EmployeeDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("lastName", "测");
        map.put("salary", "4000");
//        map.put("gender", 1);
        List<Employee> employees = sqlSessionMapper.getByMap02(map);
        employees.stream().forEach(System.out::println);
    }

    @Test
    public void update() {
        EmployeeDao sqlSessionMapper = sqlSession.getMapper(EmployeeDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("lastName", "测");
        map.put("salary", "4000");
//        map.put("gender", 1);
        Employee e = new Employee(8, "测试", "cs.com", null, null, null);
        int update = sqlSessionMapper.update(e);
        System.out.println("update = " + update);
        Employee employee = sqlSessionMapper.getById(8);
        System.out.println(employee);
    }

    @Test
    public void getByIds() {
        EmployeeDao sqlSessionMapper = sqlSession.getMapper(EmployeeDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(8);
        list.add(9);
        List<Employee> employees = sqlSessionMapper.getByIds(list);
        employees.stream().forEach(System.out::println);
    }
}
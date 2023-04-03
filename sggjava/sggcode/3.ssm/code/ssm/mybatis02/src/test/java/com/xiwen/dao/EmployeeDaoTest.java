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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void getByName() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        List<Employee> employees = employeeDao.getByName("测");
        employees.stream().forEach(System.out::println);
    }

    @Test
    public void insert() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee(null, "测试", "cs@163.com", 1, 5000.0, 1);
        int index = employeeDao.insert(employee);
        System.out.println("index = " + index);
        Employee byId = employeeDao.getById(employee.getId());
        System.out.println("rows = " + byId);
    }


    @Test
    public void getByNameAndSalary() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        List<Employee> employees = employeeDao.getByNameAndSalary("测", 3000D);
//        List<Employee> employees = employeeDao.getByNameAndSalary(new Employee("测", 3000D));
        employees.stream().forEach(System.out::println);

    }

    @Test
    public void getByNameAndSalary2() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "测");
        map.put("salary", 3000D);
        List<Employee> employees = employeeDao.getByNameAndSalary02(map);
//        List<Employee> employees = employeeDao.getByNameAndSalary(new Employee("测", 3000D));
        employees.stream().forEach(System.out::println);

    }

    @Test
    public void getByIdMap() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Map<String, Object> map = employeeDao.getByIdMap(2);
        System.out.println("map = " + map);
    }

    @Test
    public void getMaps() {
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Map<Integer, Employee> maps = employeeDao.getMaps();
        for (Map.Entry<Integer, Employee> entry : maps.entrySet()) {
            System.out.println(entry);
        }
    }
}
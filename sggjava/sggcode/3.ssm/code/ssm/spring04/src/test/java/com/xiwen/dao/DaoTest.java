package com.xiwen.dao;

import com.xiwen.bean.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/10 -15:16
 * @Version: 1.0
 */
public class DaoTest {

    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);

        System.out.println(jdbcTemplate);
//        String sql = "insert into employees values(null,?,?,?,?,?)";
//        int rows = jdbcTemplate.update(sql, "王宝强", "wangbaoqiang@qq.com", 1, 2000, 2);
//        System.out.println(rows);


//        String sql = "select last_name from employees where id = ?";
//        String name = jdbcTemplate.queryForObject(sql, String.class, 9);
//        System.out.println(name);

//        String sql = "select * from employees where id = ?";
//        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 9);
//        System.out.println(employee);

        String sql = "select * from employees where id > ?";
        List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 5);
        employees.forEach(System.out::println);
    }
}

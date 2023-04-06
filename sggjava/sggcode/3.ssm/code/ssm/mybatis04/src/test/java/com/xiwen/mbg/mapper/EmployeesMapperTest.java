package com.xiwen.mbg.mapper;

//import com.xiwen.mbg.bean.Employees;
//import com.xiwen.mbg.bean.EmployeesExample;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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


    @Test
    public void selectByExample02() {
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

        PageHelper.offsetPage(2, 3);
        List<Employees> employees = employeesMapper.selectByExample(employeesExample);

        //设置分页信息
        PageInfo<Employees> pageInfo = new PageInfo<>(employees, 3);

        int pageNum = pageInfo.getPageNum(); // 当前页
        System.out.println("pageNum = " + pageNum);
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize); // 当前页条数据
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages); //总页数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total); //总条数
        int startRow = pageInfo.getStartRow();
        System.out.println("startRow = " + startRow);
        int endRow = pageInfo.getEndRow();
        System.out.println("endRow = " + endRow);

        int prePage = pageInfo.getPrePage();
        System.out.println("prePage = " + prePage); //上一页
        int nextPage = pageInfo.getNextPage();
        System.out.println("nextPage = " + nextPage); //下一页
        int navigatePages = pageInfo.getNavigatePages(); //获取总页码
        System.out.println("navigatePages = " + navigatePages);

        boolean isFirstPage = pageInfo.isIsFirstPage(); //是否是第一页
        System.out.println("isFirstPage = " + isFirstPage);
        boolean isLastPage = pageInfo.isIsLastPage(); //是否是最后一页
        System.out.println("isLastPage = " + isLastPage);
        boolean hasPreviousPage = pageInfo.isHasPreviousPage(); //是否有上一页
        System.out.println("hasPreviousPage = " + hasPreviousPage);
        boolean hasNextPage = pageInfo.isHasNextPage(); //是否有下一页
        System.out.println("hasNextPage = " + hasNextPage);


        pageInfo.getList().stream().forEach(System.out::println);

    }
}
package com.xiwen.dao;

import com.xiwen.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    public void testMBG() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src/main/resources/mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

    }

    @Test
    public void getById() {
        SqlSession sqlSession1 = build.openSession();
        EmployeeDao sqlSessionMapper = sqlSession1.getMapper(EmployeeDao.class);
        Employee employee = sqlSessionMapper.getById(8);
        System.out.println(employee);

//        sqlSessionMapper.update(new Employee(8, "hhhh", "hhhh.com", null, null, null));
        sqlSession1.commit();

        SqlSession sqlSession2 = build.openSession();
        EmployeeDao sqlSessionMapper2 = sqlSession2.getMapper(EmployeeDao.class);
        Employee employee2 = sqlSessionMapper2.getById(8);
        System.out.println(employee2);
        sqlSession2.commit();

    }
}
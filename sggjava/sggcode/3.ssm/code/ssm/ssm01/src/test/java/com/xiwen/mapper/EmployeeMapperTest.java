package com.xiwen.mapper;

import com.xiwen.bean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/11 -15:13
 * @Version: 1.0
 */
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class EmployeeMapperTest {

//    private SqlSession sqlSession;
//    @Before
//    public void init() throws IOException {
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        sqlSession = sqlSessionFactory.openSession();
//    }

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void getById() {
//        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getById(1);
        System.out.println(employee);
    }
}
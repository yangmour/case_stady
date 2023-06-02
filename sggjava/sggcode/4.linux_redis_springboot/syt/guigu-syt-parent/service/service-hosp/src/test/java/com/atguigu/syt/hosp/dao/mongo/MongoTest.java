package com.atguigu.syt.hosp.dao.mongo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/02 -19:03
 * @Version: 1.0
 */
@SpringBootTest
public class MongoTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 使用MongoRepository操作MongoDB步骤：
     * 1.导入依赖：spring-data整合MongoDB
     * 2.在yml文件中配置mongo的5个链接信息
     * 3.创建POJO类,@Document、@Id、@field
     * 4.自定义持久化层接口继承MongoRepository<User,ObjectId>
     * 5.在测试类或者业务逻辑层注入自定义持久化层接口的代理类对象,调用现成的增删改查方法
     */
    @Test
    public void testAdd() {
        userRepository.save(new User(null, "cs", 10, "cs@163.com", new Date()));
    }

}

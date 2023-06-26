package com.xiwen.shardingjdbcdemo;

import com.xiwen.shardingjdbcdemo.entity.User;
import com.xiwen.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ShardingJdbcDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;


    /**
     * 读写分离
     */
    //写走master
    @Test
    void contextLoads() {
        User user = new User();
        user.setUname("张三");
        userMapper.insert(user);
    }

    //读走的worker01、02节点、负载均衡测试
    @Test
    public void test1() {
        userMapper.selectList(null);
        userMapper.selectList(null);
        userMapper.selectList(null);
        userMapper.selectList(null);
    }

    /**
     * 如果使用事务都走主节点
     * 但是只使用    @Transactional 在junit中会回滚
     * 如果不想回滚要使用 @Rollback(value = false) 默认是true 就是回滚
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void test2() {
        User user = new User();
        user.setUname("李四");
        userMapper.insert(user);

        userMapper.selectList(null);
    }
}

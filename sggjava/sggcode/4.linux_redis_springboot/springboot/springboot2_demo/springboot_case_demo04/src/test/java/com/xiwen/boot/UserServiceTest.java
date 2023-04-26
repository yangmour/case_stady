package com.xiwen.boot;

import com.xiwen.boot.bean.User;
import com.xiwen.boot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/25 -19:28
 * @Version: 1.0
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);
    }

    @Test
    public void insert() {
        int insert = userMapper.insert(new User(null, "张三", "男", 20, "北京", "12313", "root@qq.com", "root", "124112323"));
        System.out.println("insert = " + insert);
    }

    @Test
    public void update() {
        int update = userMapper.updateByPrimaryKey(new User(8, "李四", "男", 20, "北京", "12313", "root@qq.com", "root", "124112323"));
        System.out.println("update = " + update);
    }

    @Test
    public void delete() {
        int delete = userMapper.delete(new User(8, "李四", "男", 20, "北京", "12313", "root@qq.com", "root", "124112323"));
        System.out.println("delete = " + delete);
    }





}
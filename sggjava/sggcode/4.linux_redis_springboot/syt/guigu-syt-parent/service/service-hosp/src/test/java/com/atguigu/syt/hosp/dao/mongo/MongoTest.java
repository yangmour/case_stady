package com.atguigu.syt.hosp.dao.mongo;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    // 添加
    @Test
    public void testAdd() {
        userRepository.save(new User(null, "cs", 10, "cs@163.com", new Date()));
    }

    //批量添加
    @Test
    public void testBatchAdd() {
        List<User> list = new ArrayList<>();
        list.add(new User(null, "tom", 20, "tom@163.com", new Date()));
        list.add(new User(null, "jerry", 18, "jerry@163.com", new Date()));
        list.add(new User(null, "dog", 16, "dog@163.com", new Date()));

        List<User> userList = userRepository.insert(list);
        System.out.println(userList);
    }


    //查询所有
    @Test
    public void testFindAll() {
        List<User> all = userRepository.findAll();
        all.forEach(System.out::println);
    }

    //根据id查询
    @Test
    public void testFindById() {
        Optional<User> userOptional = userRepository.findById(new ObjectId("6479cdfc4891436160c0c6bc"));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println(user);
        }
    }

    //根据ids查询
    @Test
    public void testFindAllById() {
        List<ObjectId> list = new ArrayList<>();
        list.add(new ObjectId("647ad93980eeb37ba05b01a8"));
        list.add(new ObjectId("647ad93980eeb37ba05b01a9"));

        Iterable<User> users = userRepository.findAllById(list);
        users.forEach(System.out::println);
    }

    //条件查询，并排序
    @Test
    public void testFindAllByMatcher() {

        User user = new User();
        user.setName("o");

        ExampleMatcher matcher = ExampleMatcher.matchingAll().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> example = Example.of(user, matcher);
        Iterable<User> users = userRepository.findAll(example, Sort.by("age").ascending());
        users.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void testPage() {

        User user = new User();
        user.setName("o");

        ExampleMatcher matcher = ExampleMatcher.matchingAll().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> example = Example.of(user, matcher);
        Page<User> page = userRepository.findAll(example, PageRequest.of(1, 1));
        System.out.println(page.getTotalPages());
        System.out.println(page.getTotalElements());
        page.forEach(System.out::println);
    }


    //更新
    @Test
    public void testUpdate() {

        Optional<User> optionalUser = userRepository.findById(new ObjectId("6479cdfc4891436160c0c6bc"));
        User user = optionalUser.get();
        user.setEmail("hhhhh@163.coom");
        User save = userRepository.save(user);
        System.out.println(save);
    }

    //删除
    @Test
    public void testDelete() {

        userRepository.deleteById(new ObjectId("6479cdfc4891436160c0c6bc"));
//        userRepository.deleteAll();

    }

    //自定义方法
    @Test
    public void testzdy() {

        List<User> tom = userRepository.findByName("tom");
        System.out.println("tom = " + tom);
        List<User> jerry = userRepository.findByNameAndAge("jerry", 18);
        System.out.println("jerry = " + jerry);
        List<User> o = userRepository.findByNameLike("o");
        System.out.println("o = " + o);
    }


}

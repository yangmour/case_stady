package com.xiwen.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiwen.shardingjdbcdemo.entity.*;
import com.xiwen.shardingjdbcdemo.mapper.DictMapper;
import com.xiwen.shardingjdbcdemo.mapper.OrderItemMapper;
import com.xiwen.shardingjdbcdemo.mapper.OrderMapper;
import com.xiwen.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ShardingJdbcDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
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

    /**
     * 垂直分库测试
     */
    @Test
    public void test3() {

        User user = new User();
        user.setUname("张三");
        userMapper.insert(user);
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

        Order order = new Order();
        order.setOrderNo("ATGUIGU001");
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal(100));
        orderMapper.insert(order);
        List<Order> orders = orderMapper.selectList(null);
        System.out.println(orders);
    }

    /**
     * 水平分片：插入数据测试
     */
    @Test
    public void testInsertOrder(){

        Order order = new Order();
        order.setOrderNo("ATGUIGU001");
        order.setUserId(1L);
        order.setAmount(new BigDecimal(100));
        orderMapper.insert(order);
    }

    /**
     * 水平分片：分表插入数据测试
     */
    @Test
    public void testInsertOrderTableStrategy(){

        for (long i = 1; i < 5; i++) {

            Order order = new Order();
            order.setOrderNo("ATGUIGU" + i);
            order.setUserId(1L);
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
        }

        for (long i = 5; i < 9; i++) {

            Order order = new Order();
            order.setOrderNo("ATGUIGU" + i);
            order.setUserId(2L);
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
        }
    }

    /**
     * 测试哈希取模
     */
    @Test
    public void testHash(){

        //注意hash取模的结果是整个字符串hash后再取模，和数值后缀是奇数还是偶数无关
        System.out.println("ATGUIGU001".hashCode() % 2);
        System.out.println("ATGUIGU0011".hashCode() % 2);
    }

    /**
     * 水平分片：查询所有记录
     * 查询了两个数据源，每个数据源中使用UNION ALL连接两个表
     */
    @Test
    public void testShardingSelectAll(){

        List<Order> orders = orderMapper.selectList(null);
        orders.forEach(System.out::println);
    }

    /**
     * 水平分片：根据user_id查询记录
     * 查询了一个数据源，每个数据源中使用UNION ALL连接两个表
     */
    @Test
    public void testShardingSelectByUserId(){

        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("user_id", 1L);
        List<Order> orders = orderMapper.selectList(orderQueryWrapper);
        orders.forEach(System.out::println);
    }


    /**
     * 测试关联表插入
     */
    @Test
    public void testInsertOrderAndOrderItem(){

        for (long i = 1; i < 3; i++) {

            Order order = new Order();
            order.setOrderNo("ATGUIGU" + i);
            order.setUserId(3L);
            orderMapper.insert(order);

            for (long j = 1; j < 3; j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderNo("ATGUIGU" + i);
                orderItem.setUserId(order.getUserId());
                orderItem.setPrice(new BigDecimal(10));
                orderItem.setCount(2);
                orderItemMapper.insert(orderItem);
            }
        }

        for (long i = 5; i < 7; i++) {

            Order order = new Order();
            order.setOrderNo("ATGUIGU" + i);
            order.setUserId(4L);
            orderMapper.insert(order);

            for (long j = 1; j < 3; j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderNo("ATGUIGU" + i);
                orderItem.setUserId(order.getUserId());
                orderItem.setPrice(new BigDecimal(1));
                orderItem.setCount(3);
                orderItemMapper.insert(orderItem);
            }
        }
    }

    /**
     * 测试关联表查询
     */
    @Test
    public void testGetOrderAmount(){

        List<OrderVo> orderAmountList = orderMapper.getOrderAmount();
        orderAmountList.forEach(System.out::println);
    }

    @Autowired
    private DictMapper dictMapper;

    /**
     * 广播表：每个服务器中的t_dict同时添加了新数据
     */
    @Test
    public void testBroadcast(){

        Dict dict = new Dict();
        dict.setDictType("type1");
        dictMapper.insert(dict);
    }

    /**
     * 查询操作，只从一个节点获取数据
     * 随机负载均衡规则
     */
    @Test
    public void testSelectBroadcast(){

        List<Dict> dicts = dictMapper.selectList(null);
        dicts.forEach(System.out::println);
    }

}

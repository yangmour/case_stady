package com.xiwen;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/22 -13:43
 * @Version: 1.0
 */
public class JedisTest {

    public static void main2(String[] args) {

        //建立连接
        Jedis jedis = new Jedis("192.168.232.201", 6379);
        //设置密码
        jedis.auth("xiwen123");
//        System.out.println(jedis);
        //开始操作  方法名和redis的命令一样
        jedis.set("k1","v1");
        String s = jedis.get("k1");
        System.out.println(s);
        //关闭连接
        jedis.close();

    }

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("192.168.232.201", 6379);
        Jedis jedis = jedisPool.getResource();
        //设置密码
        jedis.auth("xiwen123");
//        System.out.println(jedis);
        //开始操作  方法名和redis的命令一样
        jedis.set("k2","v2");
        String s = jedis.get("k2");
        System.out.println(s);
        //关闭连接
        jedis.close();
    }
}

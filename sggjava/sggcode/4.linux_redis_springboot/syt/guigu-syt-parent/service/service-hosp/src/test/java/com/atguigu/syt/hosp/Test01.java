package com.atguigu.syt.hosp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class Test01 {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        Object object = redisTemplate.opsForValue().get("adminsys:token:" + "32cb96f41f2d4db89cdddfe1e220bb67");
        System.out.println(object);
        if (object == null) {
            System.out.println("空");
        }

    }
}
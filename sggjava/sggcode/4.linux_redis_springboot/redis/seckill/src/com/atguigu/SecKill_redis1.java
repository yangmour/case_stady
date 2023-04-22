package com.atguigu;

import java.io.IOException;

import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

//实验一，存在超卖情况
public class SecKill_redis1 {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SecKill_redis1.class);

    public static boolean doSecKill(String uid, String prodid) throws IOException {

        //准备key
        String skProdIdStock = "sk:" + prodid + ":stock";
        String skProdIdUIds = "sk:" + prodid + ":uid";

        Jedis jedis = new Jedis("192.168.232.201", 6379);
        jedis.auth("redis123");
        //1.当秒杀没开始的时候失败
        String count = jedis.get(skProdIdStock);
        if (count == null || count.length() == 0) {
            System.out.println("秒杀还没开始！");
            jedis.close();

            return false;
        }

        //2.当秒杀开始了，没有库存了就失败
        if (Integer.parseInt(count) <= 0) {
            System.out.println("库存以清空！");
            jedis.close();

            return false;
        }

        //3.当秒杀开始了，有库存，但是当前用户已经抢到了就返回失败
        boolean sIsMember = jedis.sismember(skProdIdUIds,uid);
        if (sIsMember) {
            System.out.println(uid + "当前用户以抢到了！！");
            jedis.close();
            return false;
        }
        //4.如果上面都不满足就让抢到，减库存，加uid，返回true
        jedis.decr(skProdIdStock);
        jedis.sadd(skProdIdUIds, uid);
        System.out.println(uid + "秒杀成功！");
        jedis.close();

        return true;
    }

}

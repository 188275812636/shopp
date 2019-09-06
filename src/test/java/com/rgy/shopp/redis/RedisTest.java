package com.rgy.shopp.redis;

import com.rgy.shopp.util.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * \* User: rgy
 * \* Date: 2019/9/6 9:37
 * \
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisClient redisClient;

    /**
     * 插入缓存数据
     */
    @Test
    public void set() {
        redisClient.set("redis_key", "redis_vale");
    }

    /**
     * 读取缓存数据
     */
    @Test
    public void get() {
        String value = redisClient.get("redis_key");
        System.out.println(value);
    }

}
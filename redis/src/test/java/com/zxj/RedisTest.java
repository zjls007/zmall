package com.zxj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    /**
     * redis 不仅仅支持字符串类型， 还支持Hash、List、Set、
     * 这里操作String类型常用opsForValue()方法
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void delete() {
        // 删除
        redisTemplate.delete("name");
    }

    @Test
    public void set() {
        // 设置key - value
        redisTemplate.opsForValue().set("name", "redis");
    }

    @Test
    public void setExpire() {
        // 设置key - value 并设置过期时长
        redisTemplate.opsForValue().set("name", "redis", 30L, TimeUnit.SECONDS);
    }

    @Test
    public void get() {
        // 根据key 获取 value
        String name = redisTemplate.opsForValue().get("name");
    }

    @Test
    public void setNX() {
        // 执行redis setNX命令
        Boolean result = redisTemplate.opsForValue().setIfAbsent("timeout", Long.toString(System.currentTimeMillis() + 30000L));
        System.out.println(result);
    }

    @Test
    public void expire() {
        // 设置过期时间
        redisTemplate.expire("timeout", 1, TimeUnit.MINUTES);
    }

    @Test
    public void hasKey() {
        // 是否存在某个key
        Boolean result = redisTemplate.hasKey("name");
        System.out.println(result);
    }

    @Test
    public void tryLock() {
        // 简单的分布式排他锁
        //  高并发下用 redission 框架实现
        tryLock("key");
    }

    @Test
    public void transactional() {
        // 这是错误写法。。。
        // 参考： https://blog.csdn.net/congcong68/article/details/52734735
        redisTemplate.multi();
        redisTemplate.opsForValue().set("name", "redis");
        redisTemplate.expire("name", 1, TimeUnit.MINUTES);
        redisTemplate.exec();
    }

    @Test
    public void transactional1() {
        // https://huoding.com/2015/09/14/463
        SessionCallback<Object> sessionCallback = new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                // 在事物情况下，这条命令拿不到结果 redis setNX命令
                operations.opsForValue().setIfAbsent("name", "redis");
                // 所以谁都可以刷新有效时间
                operations.expire("name", 1, TimeUnit.MINUTES);
                Object val = operations.exec();
                return val;
            }
        };
        Object execute = redisTemplate.execute(sessionCallback);
        System.out.println(execute);
    }

    /**
     * 尝试加锁
     * @param key
     * @return true: 加锁成功 false:加锁失败
     */
    private boolean tryLock(String key) {
        if (redisTemplate.hasKey(key)) {
            return false;
        }
        if (redisTemplate.opsForValue().setIfAbsent(key, key)) {
            redisTemplate.expire(key, 5, TimeUnit.MINUTES);
            return true;
        }
        return false;
    }

}

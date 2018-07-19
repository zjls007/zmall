package com.zxj.service.impl;

import com.zxj.service.KillService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zxj
 * @create 2018/7/19 16:26
 */
@Service("killService")
public class KillServiceImpl implements KillService {

    private static final String KEY = "totalNum";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void setNum(int num) {
        if (!redisTemplate.opsForValue().setIfAbsent(KEY, String.valueOf(num))) {
            throw new RuntimeException("其他线程已经设置过总数!");
        }
    }

    @Override
    public void rob(Long userId) {
        if (userId == null) {
            return;
        }
        Long increment = redisTemplate.opsForValue().increment(KEY, -1);
        if (increment < 0) {
            return;
        }
        rabbitTemplate.convertAndSend("saleKill", userId);
    }

}

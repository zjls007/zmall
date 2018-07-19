package com.zxj.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zxj
 * @create 2018/7/19 16:50
 */
@Component
@RabbitListener(queues = "saleKill")
public class OrderService {

    @RabbitHandler
    public void process(Long userId) {
        System.out.println(String.format("用户[%s]抢单成功,正在生成订单!", userId));
    }

}

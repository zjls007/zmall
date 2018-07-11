package com.zxj.client;

import com.zxj.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zxj
 * @create 2018/7/11 14:18
 */
@Component
@RabbitListener(queues = "user")
public class UserClient {

    @RabbitHandler
    public void process(User user) {
        System.out.println(user);
    }

}

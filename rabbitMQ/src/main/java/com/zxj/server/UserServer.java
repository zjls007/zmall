package com.zxj.server;

import com.zxj.bean.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zxj
 * @create 2018/7/11 14:12
 */
@Component
public class UserServer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg() {
        User user = new User();
        user.setId(1L);
        user.setMail("zjls007@qq.com");
        rabbitTemplate.convertAndSend("user", user);
    }

}

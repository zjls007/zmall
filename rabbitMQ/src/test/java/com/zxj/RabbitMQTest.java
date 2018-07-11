package com.zxj;

import com.zxj.client.UserClient;
import com.zxj.server.UserServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zxj
 * @create 2018/7/11 10:00
 * https://www.cnblogs.com/boshen-hzb/p/6841982.html
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RabbitMQTest {

    @Autowired
    private UserServer productServer;

    @Autowired
    private UserClient userClient;

    @Test
    public void send() {
        productServer.sendMsg();
    }

}

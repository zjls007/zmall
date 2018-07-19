package com.zxj;

import com.zxj.service.KillService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zxj
 * @create 2018/7/19 16:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {

    @Autowired
    private KillService killService;

    @org.junit.Test
    public void setNum() {
        killService.setNum(10);
    }

    @org.junit.Test
    public void rob() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ClientUser(Long.valueOf(i), killService));
        }
    }

    @org.junit.Test
    public void wait1() {
        System.out.println("");
    }
}

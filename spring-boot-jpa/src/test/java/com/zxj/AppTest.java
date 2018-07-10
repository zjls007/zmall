package com.zxj;

import com.zxj.dao.DemoDAO;
import com.zxj.entity.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {

    @Autowired
    private DemoDAO demoDAO;

    @Test
    public void select() {
        Demo demo = new Demo();
        demo.setName("zxj");
        demo = demoDAO.save(demo);
        System.out.println(demo);
    }

}

package com.zxj;

import com.zxj.entity.TaskNote;
import com.zxj.service.ITaskNoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zxj.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {

    @Autowired
    private ITaskNoteService taskNoteService;

    @Test
    public void select() {
        TaskNote taskNote = taskNoteService.selectById(1L);
        System.out.println(taskNote);
    }

}

package com.zxj.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zxj.entity.TaskNote;
import com.zxj.service.ITaskNoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxj
 * @date 2018/5/7 14:36
 */
@RestController
public class DemoConsumerController {

    @Reference
    private ITaskNoteService taskNoteService;

    @RequestMapping("/sayHello")
    public String sayHello(String name) {
        TaskNote taskNote = taskNoteService.selectById(1L);
        System.out.println(taskNote);
        return taskNote.toString();
    }

}

package com.zxj.provider;

import com.zxj.entity.TaskNote;
import com.zxj.dao.TaskNoteDAO;
import com.zxj.service.ITaskNoteService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 * 任务笔记表 服务实现类
 * </p>
 *
 * @author zxj
 * @date 2018-05-17 15:13:29
 */
@Service
public class TaskNoteServiceImpl extends ServiceImpl<TaskNoteDAO, TaskNote> implements ITaskNoteService {

}

package com.zxj.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 任务笔记表
 * </p>
 *
 * @author zxj
 * @date 2018-05-17 15:13:29
 */
@TableName("task_note")
public class TaskNote implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,not null
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务id,not null
     */
    @TableField("task_id")
    private Long taskId;

    /**
     * 日期,not null
     */
    @TableField("date")
    private Date date;

    /**
     * 备注,not null
     */
    @TableField("remark")
    private String remark;

    /**
     * 操作用户id,not null
     */
    @TableField("operate_user_id")
    private Long operateUserId;

    /**
     * ,not null
     */
    @TableField("create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(Long operateUserId) {
        this.operateUserId = operateUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
package com.zxj.entity;

import javax.persistence.*;

/**
 * @author zxj
 * @date 2018/6/5 14:35
 */
@Entity
@Table(name = "demo")
public class Demo {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.zxj.bean;

import java.io.Serializable;

/**
 * @author zxj
 * @create 2018/7/11 14:28
 */
public class User implements Serializable {

    private static final long serialVersionUID = -663333238332232874L;

    private Long id;

    private String mail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

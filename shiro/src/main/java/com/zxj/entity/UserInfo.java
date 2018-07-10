package com.zxj.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zxj
 * @date 2018/6/5 16:54
 */
@Entity
//@Table(name = "user_info", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
@Table
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -3194327012289539423L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    /**
     * 是否锁定
     */
    @Column
    private Boolean locked;

    /**
     * 盐
     */
    @Column
    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}

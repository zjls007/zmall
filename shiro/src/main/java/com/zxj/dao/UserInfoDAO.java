package com.zxj.dao;

import com.zxj.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zxj
 * @date 2018/6/5 17:09
 */
public interface UserInfoDAO extends JpaRepository<UserInfo, Long> {


}

package com.zxj.dao;

import com.zxj.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zxj
 * @date 2018/6/5 14:37
 */
@Repository
public interface DemoDAO extends JpaRepository<Demo, Long> {

}

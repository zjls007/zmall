package com.zxj.service;

/**
 * @author zxj
 * @create 2018/7/19 16:25
 */
public interface KillService {

    /**
     * 参与秒杀的商品数量
     * @param num
     */
    void setNum(int num);

    /**
     * 参与抢单
     * @param userId
     */
    void rob(Long userId);

}

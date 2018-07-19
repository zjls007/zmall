package com.zxj.bean;

import java.io.Serializable;

/**
 * @author zxj
 * @create 2018/7/19 16:34
 */
public class Goods implements Serializable {

    private static final long serialVersionUID = 2812616001965417574L;

    /**
     * 商品编码
     */
    private String goodsNo;

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}

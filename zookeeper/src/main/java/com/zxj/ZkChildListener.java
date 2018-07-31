package com.zxj;

import org.I0Itec.zkclient.IZkChildListener;

import java.util.List;

/**
 * @author zxj
 * @create 2018/7/31 11:20
 */
public class ZkChildListener implements IZkChildListener {

    @Override
    public void handleChildChange(String s, List<String> list) throws Exception {
        System.out.println(s);
    }

}

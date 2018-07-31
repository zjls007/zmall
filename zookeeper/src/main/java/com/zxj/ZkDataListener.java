package com.zxj;

import org.I0Itec.zkclient.IZkDataListener;

/**
 * @author zxj
 * @create 2018/7/31 11:27
 */
public class ZkDataListener implements IZkDataListener {
    @Override
    public void handleDataChange(String s, Object o) throws Exception {
        System.out.println(s);
    }

    @Override
    public void handleDataDeleted(String s) throws Exception {
        System.out.println(s);
    }
}

package com.zxj;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @author zxj
 * @create 2018/7/30 11:21
 */
public class Test {

    public static void main(String[] args) {
        String path = "/dubbo/com.zxj.service.ITaskNoteService";
        List<String> children = ZkClientUtil.getChildren(path);
        System.out.println(children);
    }

}

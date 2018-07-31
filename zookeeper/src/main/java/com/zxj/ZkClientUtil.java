package com.zxj;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @author zxj
 * @create 2018/7/30 14:04
 */
public class ZkClientUtil {

    public static ZkClient zkClient = null;

    public static ZkClient getZkClient() {
        if (zkClient == null) {
            // 172.16.1.109:2181
            // 192.168.99.100:2181
            zkClient = new ZkClient("192.168.99.100:2181", 5000, 5000, new SerializableSerializer());
        }
        return zkClient;
    }

    /**
     * 是否存在节点
     * @param path
     * @return
     */
    public static boolean exists(String path) {
        return getZkClient().exists(path);
    }

    /**
     * 读取节点数据
     * @param path
     * @return
     */
    public static Object readData(String path) {
        return getZkClient().readData(path);
    }

    /**
     * 修改节点数据
     * @param path
     * @return
     */
    public static void writeData(String path, Object o) {
        getZkClient().writeData(path, o);
    }

    /**
     * 创建节点
     * @param path
     * @param data
     * @param mode
     * @return
     */
    public static String createNode(String path, Object data, CreateMode mode) {
        return getZkClient().create(path, data, mode);
    }

    /**
     * 删除
     * @param path
     * @return
     */
    public static boolean delete(String path) {
        return getZkClient().delete(path);
    }

    /**
     * 递归删除
     * @param path
     * @return
     */
    public static boolean deleteRecursive(String path) {
        return getZkClient().deleteRecursive(path);
    }

    /**
     * 读取子节点
     * @param path
     * @return
     */
    public static List<String> getChildren(String path) {
        return getZkClient().getChildren(path);
    }

}

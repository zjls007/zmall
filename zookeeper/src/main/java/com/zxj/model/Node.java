package com.zxj.model;

import java.io.Serializable;

/**
 * @author zxj
 * @create 2018/7/30 13:45
 */
public class Node implements Serializable  {

    private static final long serialVersionUID = 110101736313353952L;

    public Node() {

    }

    public Node(String name,  String url) {
        this.name = name;
        this.url = url;
    }


    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

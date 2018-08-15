package com.zxj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxj
 * @create 2018/8/15 13:41
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class UserProviderCluster1Application {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderCluster1Application.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    @ResponseBody
    public Object home() {
        return "port: " + port;
    }

}

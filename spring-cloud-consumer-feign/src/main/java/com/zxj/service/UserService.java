package com.zxj.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zxj
 * @create 2018/8/15 14:45
 */
@FeignClient(value = "user-provider")
public interface UserService {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showPort();

}

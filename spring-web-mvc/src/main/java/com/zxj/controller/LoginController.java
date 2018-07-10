package com.zxj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxj
 * @date 2018/5/29 14:13
 */
@Controller
public class LoginController {

    /**
     * {@link DispatcherServlet}
     * {@link org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter}
     * @param modelMap
     * @return
     */
    @RequestMapping("index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name", "index");
        return "index";
    }

    @RequestMapping("json")
    @ResponseBody
    public Object json() {
        Map map = new HashMap();
        map.put("key", "value");
        return map;
    }

    @RequestMapping("text")
    @ResponseBody
    public String text() {
        return "ok";
    }

    /**
     * {@link DispatcherServlet}
     * @param modelMap
     * @return
     */
    @RequestMapping("logout")
    public String logout(ModelMap modelMap) {
        modelMap.addAttribute("name", "index");
        return "index";
    }

}

package com.zxj.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zxj
 * @date 2018/5/25 15:45
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String showLoginForm(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping("index")
    public String showLoginForm() {
        return "index";
    }

    @GetMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }

    /**
     * shiro控制为只有登录失败才会到这个方法
     * @param request
     * @return
     */
    @PostMapping("login")
    public Object login(HttpServletRequest request, ModelMap modelMap) {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isAuthenticated());

        String result = "";
        String exceptionClassName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (exceptionClassName != null) {
            // 用户不存在
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                result = "用户不存在！";
                // 密码错误
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                result = "密码错误！";
            } else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
                result = "账户被锁定！";
            } else if (AuthenticationException.class.getName().equals(exceptionClassName)) {
                // 这里有可能为库中的盐不正确
                result = "密码错误！";
            }
        }
        modelMap.addAttribute("failureMsg", result);
        return "login";
    }

    @RequestMapping("role/{role}")
    @ResponseBody
    public Object hasRole(@PathVariable String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

    @RequestMapping("perm/{perm}")
    @ResponseBody
    public Object isPermitted(@PathVariable String perm) {
        return SecurityUtils.getSubject().isPermitted(perm);
    }

    @RequestMapping("role/{role}/anno")
    @ResponseBody
    @RequiresRoles("admin1")
    public Object hasRole1(@PathVariable String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

}

package com.yufei.demo.controller;

import com.yufei.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController
{
    @RequestMapping("/login")
    public String loginProfile(){
        return "LoginPage";
    }

    @RequestMapping("/register")
    public String registerProfile(){
        return "RegisterPage";
    }
    @RequestMapping(value = "/login",params = {"register"})
    public String LogRegisterProfile(){
        return "RegisterPage";
    }
    //引入@ResponseBody，可直接返回json串
    @ResponseBody
    @RequestMapping(value="/setUser")
    public User getUser(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        return user;
    }
}

package com.yufei.demo.controller;

import com.yufei.demo.model.User;
import com.yufei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param name 账户
     * @param pwd 设置密码
     */
   /* @PostMapping("/createUser")*/
   @RequestMapping("/createUser")
    public void createUser(@RequestParam("name") String name, @RequestParam("pwd") String pwd){
        userService.createUser(name,pwd);
    }

    /**
     * 更新用户信息
     * @param user_id 用户ID
     * @param nickName 昵称
     */
    /*@PutMapping("/updateUser/{id}")*/
    @RequestMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName){
        userService.updateUser(user_id,nickName);
    }

    /**
     * 获取用户信息
     * @param id 用户Id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id")  Integer id){
        return userService.getUser(id);
    }

    /*@DeleteMapping("/deleteUserByUserId/{id}")*/
    @RequestMapping("/deleteUserByUserId/{id}")
    public void deleteUserByUserId(@PathVariable("id")  Integer id){
        userService.deleteUserByUserId(id);
    }
}

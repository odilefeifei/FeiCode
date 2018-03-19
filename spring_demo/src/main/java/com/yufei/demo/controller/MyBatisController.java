package com.yufei.demo.controller;

import com.yufei.demo.model.User;
import com.yufei.demo.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RequestMapping("/mybatis")

@RestController
public class MyBatisController {
    @Autowired
    private MybatisService service;


    /**
     * 更新用户信息
     * @param user_id 用户ID
     * @param nickName 昵称
     */
    //@PutMapping("/updateUser/{id}")
    @RequestMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName){
        service.updateUser(user_id,nickName);
    }

    /**
     * 获取用户信息
     * @param id 用户Id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id")  Integer id){
        return service.getUser(id);

    }

    /**
     * 删除用户
     * @param tel
     */
    //@DeleteMapping("/deleteUserByUserId/{tel}")
    @RequestMapping("/deleteUserByUserId/{tel}")
    public void deleteUserByUserId(@PathVariable("tel")  String tel){
        User user  = new User();
        user.setTel(tel);
        service.deleteUserByUserId(user);

    }

    /**
     * 使用@RequestBody获取参数，用map类型接收，再取出
     * @param reqMap
     */
    //@PostMapping("/createUserByMap")
    @RequestMapping("/createUserByMap")
    public void createUserByMap(@RequestBody Map<String,Object> reqMap){
        service.createUser(reqMap);

    }


}

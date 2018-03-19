package com.yufei.demo.service;

import com.yufei.demo.dao.UserInfoMapper;
import com.yufei.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    public void createUser(String name,String pwd){
        userInfoMapper.createUser(name, pwd);

    }

    public User getUser(Integer id){
        return userInfoMapper.getUser(id);
    }

    public  void updateUser(String user_id, String nickName){
        userInfoMapper.updateUser(user_id,nickName);

    }

    public void deleteUserByUserId(Integer id){
        userInfoMapper.deleteUserByUserId(id);

    }



}

package com.yufei.demo.dao;

import com.yufei.demo.model.User;
/*Dao层*/
public interface UserInfoMapper {
    void createUser(String name, String pwd);

    User getUser(Integer id);

    void updateUser(String user_id, String nickName);

    void deleteUserByUserId(Integer id);
}

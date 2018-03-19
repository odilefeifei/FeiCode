package com.yufei.demo.dao;

import com.yufei.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoImpl implements UserInfoMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createUser(String name,String pwd){

        jdbcTemplate.update("INSERT INTO user(id,username,password,nickname) VALUES (?,?,?,'')","1113",name,pwd);

    }
    @Override
    public User getUser(Integer id){
        List<User> userList = jdbcTemplate.query("select id,username,tel,nickname,password FROM user WHERE id = ?",new Object[]{id},new BeanPropertyRowMapper(User.class));
        if(userList != null && userList.size() > 0){
            User user = userList.get(0);
            return user;
        }else {
            return null;
        }

    }
    @Override
    public  void updateUser(String user_id, String nickName){
        jdbcTemplate.update("UPDATE user SET nickname = ? WHERE id = ?",nickName,user_id);
    }
    @Override
    public void deleteUserByUserId(Integer id){
        jdbcTemplate.update("DELETE FROM user WHERE id = ?",id);
    }
}

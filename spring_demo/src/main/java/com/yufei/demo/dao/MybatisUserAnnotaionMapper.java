package com.yufei.demo.dao;

import com.yufei.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;
@Mapper
public interface MybatisUserAnnotaionMapper {
    //采用Map传参
    @Insert("INSERT INTO user(username,password,nickname,tel) VALUES (#{username},#{password},'',#{tel})")
    void createUser(Map<String, Object> reqMap);
    //使用@Param传参
    @Select("select username,tel,nickname,password FROM user WHERE id = #{id}")
    User getUser(@Param("id") Integer id);

    @Update("UPDATE user SET nickname = #{nickName} WHERE id = #{userId}")
    void updateUser(@Param("userId") String user_id, @Param("nickName") String nickName);
    //采用对象User传参
    @Delete("DELETE FROM user WHERE tel = #{tel}")
    void deleteUserByUserId(User userInfo);
}

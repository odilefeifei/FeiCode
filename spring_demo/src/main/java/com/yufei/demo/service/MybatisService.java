package com.yufei.demo.service;

import com.yufei.demo.dao.MybatisUserAnnotaionMapper;
import com.yufei.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class MybatisService {
    @Autowired
    private MybatisUserAnnotaionMapper annotaionMapper;

    //其中参数的命名规则和MybatisUserAnnotaionMapper的@Param("userId")相似
    public void updateUser(String userId, String nickName) {
        annotaionMapper.updateUser(userId,nickName);
    }

    public User getUser(Integer id) {
        return annotaionMapper.getUser(id);
    }

    public void deleteUserByUserId(User userInfo) {
        annotaionMapper.deleteUserByUserId(userInfo);
    }

    public void createUser(Map<String, Object> reqMap) {
        annotaionMapper.createUser(reqMap);
    }
}

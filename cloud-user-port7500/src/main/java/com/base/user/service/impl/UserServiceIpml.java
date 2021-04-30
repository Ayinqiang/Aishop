package com.base.user.service.impl;

import com.base.pojo.User;
import com.base.pojo.UserData;
import com.base.user.dao.UserMapper;
import com.base.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service(value = "userService")
public class UserServiceIpml implements UserService {

    //日志slf4j对象
    Logger logger = LoggerFactory.getLogger(UserServiceIpml.class);

    //用户Dao层操作对象
    @Resource
    UserMapper userMapper;

    @Override
    public Integer userIdExisted(Integer uid) {
        Integer res = null;
        try{
            res = userMapper.SelectUserById(uid);
        }catch (Exception e){
            logger.error("查询失败");
        }
        return res;
    }



    @Override
    @Transactional
    public void InsertUser(User user) {
        userMapper.InsertUser(user);
    }

    @Override
    public UserData getUserData() {
        return null;
    }

    @Override
    public void updateUserData() {

    }
}

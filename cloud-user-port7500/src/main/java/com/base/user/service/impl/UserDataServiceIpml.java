package com.base.user.service.impl;

import com.base.pojo.UserData;
import com.base.user.dao.UserDataMapper;
import com.base.user.service.UserDataService;
import com.base.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton :
 */

@Slf4j
@Service("userDataService")
public class UserDataServiceIpml implements UserDataService {



    @Autowired
    UserDataMapper userDataMapper;

    /**
     *
     * @param userData
     * @Descripton 插入用户数据
     */
    @Override
    public void InsertUserData(UserData userData) {
        userDataMapper.InsertUser(userData);
    }
}

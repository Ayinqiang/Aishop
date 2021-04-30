package com.base.user.service;

import com.base.pojo.UserData;
import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton : 用户服务接口层
 */

public interface UserService {

    /**
     * @Param uid 用户id
     * @Description : 查询用户是否存在
     */
    public boolean userIdExisted(Integer uid);

    public UserData getUserData();
    public void updateUserData();
}

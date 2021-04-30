package com.base.user.service;

import com.base.pojo.User;
import com.base.pojo.UserData;
import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton : 用户服务接口层
 */

public interface UserService {

    /**
     * @Description: 检查用户是否存在
     * @param uid
     * @return 查询结果
     */
    public Integer userIdExisted(Integer uid);

    /**
     * @Description: 注册时用于插入用户
     * @param user
     */
    public void InsertUser(User user);
    public UserData getUserData();
    public void updateUserData();
}

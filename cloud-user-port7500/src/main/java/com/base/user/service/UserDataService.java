package com.base.user.service;

import com.base.pojo.UserData;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton :
 */
public interface UserDataService {

    public void InsertUserData(UserData userData);

    public UserData GetUserData(String uid);
}

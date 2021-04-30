package com.base.user.dao;

import com.base.pojo.UserData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton : 用户数据接口层
 */
@Repository
public interface UserDataMapper {

    public void InsertUser(@Param("ud")UserData userData);
}

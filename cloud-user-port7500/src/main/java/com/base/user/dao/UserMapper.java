package com.base.user.dao;

import com.base.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    /**
     * @Description: 检测用户账号是否存在
     * @Params uid： 用户id号码
     */
    public String SelectUserById(@Param("uid") String uid);

}

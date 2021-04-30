package com.base.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    public Integer SelectUserById(@Param("uid") Integer uid);
}

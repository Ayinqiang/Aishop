package com.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton : 用户实体类
 */

@Data
@AllArgsConstructor
public class User {
    private Integer uid;          //用户id号码
    private String psw;       //用户密码
    /*
    * 0 代表用户
    * 1 代表管理员
    * 2 代表超级管理员 */
    private Integer authorities;  //

    public User(User user){
        this.uid = user.getUid();
        this.psw = user.getPsw();
        this.authorities = user.getAuthorities();
    }
}

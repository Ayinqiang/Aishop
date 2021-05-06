package com.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton : 用户信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private int id;          //自增id
    private String uid;       //用户id号码
    private String psw;       //用户密码
    /*
     * 0 代表用户
     * 1 代表管理员
     * 2 代表超级管理员 */
    private Integer authorities;  //
    private Integer sex;      //用户性别
    private String name;      //用户名
    private String sign;      //用户签名
    private String avatar;    //用户头像地址
    private String email;     //用户邮件地址
    private String phone;     //用户手机号码

}

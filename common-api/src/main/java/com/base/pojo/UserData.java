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
    private Integer uid;          //用户id号码
    private Integer sex;          //用户性别
    private String name;      //用户名
    private String sign;      //用户签名
    private String avatar;    //用户头像地址
    private String email;     //用户邮件地址
    private String phone;     //用户手机号码

}

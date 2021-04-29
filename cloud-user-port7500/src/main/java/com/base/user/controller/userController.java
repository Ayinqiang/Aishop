package com.base.user.controller;


import com.base.user.pojo.User;
import com.base.util.Result;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;


@Api(value = "用户信息操作控制器")
@Controller
@ResponseBody
public class userController {


    @PostMapping(value = "/regesity")
    public Result regesity(){
        User user = new User("你好",1245);
        return new Result(2000,"ssss","这是我的结果");
    }
}

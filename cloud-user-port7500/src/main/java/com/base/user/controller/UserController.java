package com.base.user.controller;


import com.base.pojo.User;
import com.base.user.service.UserService;
import com.base.user.service.impl.UserServiceIpml;
import com.base.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(value = "用户信息操作控制器")
@RestController
public class UserController {

    @Resource
    @Qualifier(value = "userService")
    UserService userService;



    @GetMapping(value = "/existUid")
    public Result existUid(@RequestParam(name = "uid") int uid){
        boolean res = userService.userIdExisted(uid);
        if(res)
            return Result.error("失败了 已经存在",1000);
        else
            return Result.success(res);
    }

    @GetMapping(value = "/existUid/{uid}")
    public Result ss(@PathVariable("uid") Integer uid){
        boolean res = userService.userIdExisted(uid);
        if(res)
            return Result.error("失败了 已经存在",1000);
        else
            return Result.success(res);
    }
}

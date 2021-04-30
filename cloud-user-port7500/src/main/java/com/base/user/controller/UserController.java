package com.base.user.controller;


import com.base.pojo.User;
import com.base.pojo.UserData;
import com.base.user.service.UserDataService;
import com.base.user.service.UserService;
import com.base.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Api(value = "用户信息操作控制器")
@RestController
public class UserController {

    @Resource
    @Qualifier(value = "userService")
    UserService userService;


    @Resource
    @Qualifier(value = "userDataService")
    UserDataService userDataService;


    @PostMapping(value = "/existUid")
    public Result existUid(@RequestBody User user){
        log.info(user.toString());
        return Result.success(user);
    }

    @GetMapping(value = "/existUid/{uid}")
    public Result ss(@PathVariable("uid") Integer uid){
        System.out.println(uid);
        Integer res = userService.userIdExisted(uid);
        System.out.println(res);
        if(res!=null)
            return Result.error("失败了 已经存在",1000);
        else
            return Result.success(res);
    }

    @ApiOperation(value = "用户注册接口",notes = "传入用户实体 默认权限为普通用户")
    @ApiImplicitParam(name = "User",required = true)
    @PostMapping(value = "/register")
    @Transactional
    public Result<UserData> registyUser(@RequestParam(value = "user") User user,@RequestParam(value = "userData") UserData userData){
            log.info(user.toString());
            log.info(userData.toString());
        if(userService.userIdExisted(user.getUid())!=null){
                return Result.error("用户账号已经存在请勿重复注册",1000);
            }else{
                userService.InsertUser(user);
                userDataService.InsertUserData(userData);
            }
        return Result.success(userData);
    }
}

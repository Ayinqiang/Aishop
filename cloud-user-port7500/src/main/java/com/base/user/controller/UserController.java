package com.base.user.controller;


import com.base.pojo.User;
import com.base.pojo.UserData;
import com.base.user.dao.UserDataMapper;
import com.base.user.service.UserDataService;
import com.base.user.service.UserService;
import com.base.util.CookieUtils;
import com.base.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*",maxAge = 3600)
@Slf4j
@Api(value = "用户信息操作控制器")
@RestController
@RequestMapping("/serverForAishop")
public class UserController {

    @Resource
    @Qualifier(value = "userService")
    UserService userService;

    @Resource
    @Qualifier(value = "userDataService")
    UserDataService userDataService;

    @Autowired
    UserDataMapper userDataMapper;


    @ApiOperation(value = "用户注册接口", notes = "传入用户实体 默认权限为普通用户")
    @ApiImplicitParam(name = "User", required = true)
    @PostMapping(value = "/registerUser")
    @Transactional
    public Result<UserData> registyUser(@RequestBody UserData userData) {
        if (userService.userIdExisted(userData.getUid()))
            return Result.error("用户id号码已经存在", 2001);
        //默认为普通管理员
        userData.setAuthorities(0);
        userData.setSign("这个人很懒 什么也没留下");
        userData.setAvatar("https://pic1.zhimg.com/80/v2-a3f280b93541e96cad62ffc659e01a60_720w.jpg?source=1940ef5c");
        userDataService.InsertUserData(userData);
        return Result.success(userData);
    }

    @ApiOperation(value = "用户登录接口", notes = "传入用户uid")
    @GetMapping("/login")
    public Result<UserData> login(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        String psw = request.getParameter("psw");
        log.info(uid + " "+ psw);
        System.out.print(userDataMapper.GetPswByUid(uid));
        if (!userService.userIdExisted(uid)) {
            return Result.error("用户号码不存在", 2001);
        }
        String TruePsw = userDataMapper.GetPswByUid(uid);
        log.info(TruePsw);
        if (TruePsw!=null && TruePsw.equals(psw)) {
            //获取用户信息
            UserData userData = userDataMapper.GetUserData(uid);
            //添加用户Cookie
            CookieUtils.removeCookie(request,response,"aishop-userInfo");
            CookieUtils.addCookie(request,response,"aishop-userInfo",userData.getUid());
            return Result.success(userDataService.GetUserData(uid));
        }
        else
            return Result.error("密码错误", 2001);
    }

    @ApiOperation(value = "获取用户相关信息",notes = "传入用户id")
    @GetMapping("/UserInfo")
    public Result<UserData> getUserInfo(HttpServletRequest request,HttpServletResponse response){
        String uid = request.getParameter("uid");
        UserData userData = userDataMapper.GetUserData(uid);
        return Result.success(userData);
    }
}

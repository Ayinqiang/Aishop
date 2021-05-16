package com.base.common.controller;

import com.base.common.service.NavService;
import com.base.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author PPmaster
 * @since 2021/5/9 22:05
 */
@RestController
public class NavController {

    @Autowired
    NavService navService;

    @GetMapping("/NavList")
    public Result<List> getNavMap(){
        return navService.getNavItemAllList();
    }
}

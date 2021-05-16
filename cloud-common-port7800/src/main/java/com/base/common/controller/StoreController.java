package com.base.common.controller;

import com.base.common.service.StoreService;
import com.base.pojo.Store;
import com.base.pojo.StoreImgs;
import com.base.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author PPmaster
 * @since 2021/5/12 23:03
 */
@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/getStoreList")
    public Result getStoreList(){
        ArrayList<Store> list = (ArrayList<Store>) storeService.getAllStoreList();
        return Result.success(list);
    }

}

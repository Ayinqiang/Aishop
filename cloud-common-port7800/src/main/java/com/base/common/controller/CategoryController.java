package com.base.common.controller;

import com.base.common.service.CategoryService;
import com.base.pojo.Category;
import com.base.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/13 22:08
 */
@RestController
public class CategoryController implements Serializable {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/Category")
    public Result getAllCategory(){
        List<Category> list = new ArrayList<Category>();
        list = categoryService.getAllCategory();
        return Result.success(list);
    }
}

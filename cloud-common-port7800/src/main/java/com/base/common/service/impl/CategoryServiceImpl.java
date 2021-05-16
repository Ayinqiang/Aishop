package com.base.common.service.impl;

import com.base.common.dao.CategoryMapper;
import com.base.common.service.CategoryService;
import com.base.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/13 22:10
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }
}

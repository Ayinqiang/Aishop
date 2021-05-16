package com.base.common.dao;

import com.base.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/13 22:09
 */
@Mapper
public interface CategoryMapper {
    public List<Category> getAllCategory();
}

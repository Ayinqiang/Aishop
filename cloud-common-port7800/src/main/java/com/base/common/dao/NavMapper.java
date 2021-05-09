package com.base.common.dao;

import com.base.common.pojo.NavItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/9 22:05
 */
@Component
public interface NavMapper {

    /**
     * 查询导航项列表
     * @param itemId 对应列表项id
     * @return 返回列表
     */
    public List<NavItem> SelectNavItemList(@Param("id") int itemId);
}

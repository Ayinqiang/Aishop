package com.base.common.service.impl;

import com.base.common.dao.NavMapper;
import com.base.common.pojo.NavItem;
import com.base.common.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于左侧导航栏
 * @author PPmaster
 * @since 2021/5/9 22:06
 */
@Service
public class NavServiceImpl implements NavService {

    @Autowired
    NavMapper navMapper;

    @Override
    public Map<Integer,List<NavItem>>  getNavItemAllList() {
        int[] allId = new int[]{0,1,2};
        Map<Integer,List<NavItem>> navMap = new HashMap<>();
        for(int i = 0;i < allId.length;i++){
            navMap.put(allId[i],navMapper.SelectNavItemList(allId[i]));
        }
        return navMap;
    }
}

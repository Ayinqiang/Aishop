package com.base.common.service;

import com.base.common.pojo.NavItem;

import java.util.List;
import java.util.Map;

/**
 * @author PPmaster
 * @since 2021/5/9 22:06
 */
public interface NavService {

    public Map<Integer,List<NavItem>> getNavItemAllList();

}

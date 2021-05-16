package com.base.common.service.impl;

import com.base.common.dao.NavMapper;
import com.base.common.pojo.NavItem;
import com.base.common.service.NavService;
import com.base.util.Result;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于左侧导航栏
 *
 * @author PPmaster
 * @since 2021/5/9 22:06
 */
@Service
public class NavServiceImpl implements NavService {

    private static final int MAX_LENGTH = 15;

    @Autowired
    NavMapper navMapper;

    @Override
    public Result<List> getNavItemAllList() {
        int[] allId = new int[]{0, 1, 2};
        ArrayList<NavList> list = new ArrayList<>();
        for (int i = 0; i < allId.length; i++) {
            String name = null;
            String icon = null;
            switch (i) {
                case 0:
                    name = "常规";
                    icon = "mdi-apple-keyboard-command";
                    break;
                case 1:
                    name = "用户信息";
                    icon = "mdi-account-box-outline";
                    break;
                case 2:
                    name = "商城模块";
                    icon = "mdi-home-variant-outline";
                    break;
                case 3:
                    name = "订单信息";
                    break;
                default:
                    break;
            }
            NavList item = new NavList();
            item.setName(name);
            item.setIcon(icon);
            item.setNavItems(navMapper.SelectNavItemList(i));
            list.add(item);
        }
        return new Result<List>(list);
    }
}

@Data
class NavList {
    String icon;
    String name;
    List<NavItem> navItems;
}

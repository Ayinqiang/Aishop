package com.base.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author PPmaster
 * @since 2021/5/9 22:15
 */
@Data
@Alias("NavItem")
@AllArgsConstructor
public class NavItem {
    private int itemId;     //导航项Id
    private String text;    //导航项名字
    private String router;  //导航项路由地址
    private int authority;  //导航项 权限 0 为限定普通用户 1 为 管理员
    private String icon;    //图标
    /**
     * 0 直接显示
     * 1 显示在用户下模块
     * 2 显示在商城下
     * 3 显示在订单中
     */
    private int belong;     //属于
}

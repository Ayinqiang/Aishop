package com.base.util;

import cn.hutool.core.lang.Assert;

/**
 * @Author Administrator
 * @Date 2021/4/29
 * @Descripton 断言工具包
 */
public class AssertUtils {

    public static void notNullPrintType(Object object){
        Assert.notNull(object,object.getClass()+"不允许为空");
    }

    public static void notEmptyPrintType(Object object){

    }
}

package com.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton :
 */
@Data
@AllArgsConstructor
public class Store {
    private int id;               //自增id
    private String storeId;          //物品Id
    private String name;          //用户名
    private String[] arrImg;      //图片数组
    private String text;          //物品描述
    private Integer storeClass;       //物品类别
    private Double price;         //物品价格
}

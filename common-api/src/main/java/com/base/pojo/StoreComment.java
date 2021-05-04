package com.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton : 商品评论
 */

@Data
@AllArgsConstructor
public class StoreComment {
    private int id;               //自增id
    private String uid;       //用户id
    private String orderId;   //订单id
    private String commentText;   //物品id
    private Date createTime; //创建时间
}

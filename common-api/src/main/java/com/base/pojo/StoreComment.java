package com.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton : 商品评论
 */

@Data
@AllArgsConstructor
public class StoreComment {
    private int orderId;   //订单id
    private int storeId;   //物品id
}

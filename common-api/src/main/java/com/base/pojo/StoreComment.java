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
    private Integer orderId;   //订单id
    private Integer storeId;   //物品id
}

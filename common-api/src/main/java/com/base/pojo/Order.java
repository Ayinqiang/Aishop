package com.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton :
 */
@Data
@AllArgsConstructor
public class Order {
    private int id;                   //自增id
    private String orderId;          //订单id
    private String buyerId;          //买家id
    private String sellerId;         //卖家id
    private String state;            //订单状态
    /*
    * 0 订单未完成 正常状态
    * 1 订单未完成 异常  售后
    * 2 订单未完成 退款
    * 3 订单已完成*/
    private Double overall;       //订单总金额
    private Date createTime;    //订单创建时间
    private Date endTime;       //订单关闭时间
}

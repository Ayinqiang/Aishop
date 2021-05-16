package com.base.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton : 商品评论
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreComment {
    private int id;               //自增id
    private String uid;           //用户id
    private String commentId;     //评论id
    private String storeId;       //订单id
    private String parentId;      //父亲评论id
    private String commentText;   //物品id
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;      //创建时间
//    @JsonIgnoreProperties
//    @JsonIgnore
    private StoreComment storeComment;
    private UserData userData;
}

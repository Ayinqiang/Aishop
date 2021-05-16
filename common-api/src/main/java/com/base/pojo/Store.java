package com.base.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/4/30
 * @Descripton :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store  implements Serializable {
    private Integer id;               //自增id
    private String storeId;       //物品Id
    private String names;          //名称

    private String description;   //物品描述
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;      //创建时间
    private Integer storeClass;   //物品类别
    private Double price;         //物品价格
    private List<StoreImgs> arrImg;      //图片数组

    public Store(Integer id, String storeId, String names, String description, Date createDate, Integer storeClass, Double price) {
        this.id = id;
        this.storeId = storeId;
        this.names = names;
        this.description = description;
        this.createDate = createDate;
        this.storeClass = storeClass;
        this.price = price;
    }
}

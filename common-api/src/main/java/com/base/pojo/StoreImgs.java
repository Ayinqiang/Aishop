package com.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author PPmaster
 * @since 2021/5/12 23:22
 */
@Data
@AllArgsConstructor
public class StoreImgs {
    private Integer id;
    private String storeId;
    private String imgs;
}

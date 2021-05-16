package com.base.common.dao;

import com.base.pojo.Store;
import com.base.pojo.StoreImgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/12 23:03
 */
@Mapper
public interface StoreMapper {

    /**
     * 查询所有的商品
     * @return
     */
    public List<Store> getAllStoreList();

}

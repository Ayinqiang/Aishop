package com.base.common.dao;

import com.base.pojo.StoreComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/15 14:54
 */
@Mapper
public interface StoreCommentDao {
    /**
     * 通过商品的id获取商品评论信息
     * @param commentId
     * @return
     */
    public List<StoreComment> getStoreCommentById(@Param("storeId") String commentId);


    public void insertStoreComment(@Param("StoreComment") StoreComment storeComment);
}

package com.base.common.service;

import com.base.pojo.Store;
import com.base.pojo.StoreComment;

import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/15 14:55
 */
public interface CommentService {
    public List<StoreComment> getStoreCommentByCommnetId(String commentId);

    public void insertStoreComment(StoreComment storeComment);
}

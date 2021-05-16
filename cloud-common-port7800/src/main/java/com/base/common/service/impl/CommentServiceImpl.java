package com.base.common.service.impl;

import com.base.common.dao.StoreCommentDao;
import com.base.common.service.CommentService;
import com.base.pojo.StoreComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/15 14:58
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    StoreCommentDao storeCommentDao;
    @Override
    public List<StoreComment> getStoreCommentByCommnetId(String storeId) {

        return storeCommentDao.getStoreCommentById(storeId);
    }

    @Override
    public void insertStoreComment(StoreComment storeComment) {
        storeCommentDao.insertStoreComment(storeComment);
    }


}

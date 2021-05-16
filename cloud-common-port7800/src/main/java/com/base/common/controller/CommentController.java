package com.base.common.controller;

import com.base.common.service.CommentService;
import com.base.pojo.StoreComment;
import com.base.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author PPmaster
 * @since 2021/5/15 15:18
 */
@Slf4j
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;


    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/getCommentByCommentId")
    public Result getCommentByStoreId(@RequestParam("storeId") String storeId){
        log.info(storeId);
        ArrayList<StoreComment> list = (ArrayList<StoreComment>) commentService.getStoreCommentByCommnetId(storeId);
        return Result.success(list);
    }

    @PostMapping("/postCommentByStoreId")
    public Result postCommentByStoreId(HttpServletRequest request, HttpServletResponse response){
        try {

        }catch (Exception e){
            log.info(e.getMessage());
            Result.error("评论出错",5000);
        }
        String commentText = request.getParameter("commentText");
        String parentId = request.getParameter("parentId");
        String storeId = request.getParameter("storeId");
        String uid = request.getParameter("uid");


        StoreComment storeComment = new StoreComment();
        storeComment.setUid(uid);
        storeComment.setCommentId(UUID.randomUUID().toString().substring(0,10));
        storeComment.setCommentText(commentText);
        if(parentId!=null){
            storeComment.setParentId(parentId);
        }
        storeComment.setParentId(uid);
        storeComment.setStoreId(storeId);

        //设置时间
        Date ctime = new java.sql.Date(new java.util.Date().getTime());
        storeComment.setCreateTime(ctime);
        commentService.insertStoreComment(storeComment);
         return Result.success(null);
    }
}

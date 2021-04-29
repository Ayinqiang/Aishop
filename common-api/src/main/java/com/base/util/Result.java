package com.base.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private int code; //返回代码
    private String msg; //返回的消息
    private T data;  //返回的数据

    //成功快速返回成功状态以及消息
    public Result(T data) {
        this.code = 4000;
        this.msg = "success";
        this.data = data;
    }

    //失败快速构建返回失败对象
    public Result(String msg, int code) {
        this.code = code;
        this.msg = "msg";
    }

    /**
     * 失败的时候调用
     */
    public static <T> Result<T> error(String msg,int code) {
        return new Result<T>(msg,code);
    }

    /**
     *成功的时候调用
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }
}

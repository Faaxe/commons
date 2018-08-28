package com.faxe.web.controller.message;

import lombok.Data;

import java.io.Serializable;

/**
 * 消息返回
 * controller 对请求作出响应后，封装响应结果返回客户端。
 *
 * @author Xiang Zhou
 * @create 2018-08-28 16:36
 **/
@Data
public class ResponseMessage<T> implements Serializable {
    private static final long serialVersionUID = 8992436576262574064L;

    /**
     * 响应状态码 200-OK 500-ERROR
     */
    protected int status;

    /**
     * 业务自定义状态码
     */
    protected String code;

    /**
     * 响应返回的内容
     */
    protected T result;

    /**
     * 错误消息
     */
    protected String message;

    /**
     * 时间戳
     */
    protected Long timestamp;

    //链式表达
    public ResponseMessage<T> status(int status){
        this.status = status;
        return this;
    }

    public ResponseMessage<T> code(String code){
        this.code = code;
        return this;
    }

    public ResponseMessage<T> result(T result){
        this.result = result;
        return this;
    }

    public ResponseMessage<T> message(String message){
        this.message = message;
        return this;
    }

    public static <T> ResponseMessage<T> SUCCESS(T result){
        return new ResponseMessage<T>()
                .result(result)
                .putTimeStamp()
                .status(200);
    }
    public static <T> ResponseMessage<T> ERROR(T result){
        return new ResponseMessage<T>()
                .result(result)
                .putTimeStamp()
                .status(500);
    }
    //设置当前时间戳
    private ResponseMessage<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }
}
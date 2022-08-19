package com.dxh.domain;

import com.dxh.enums.ResponseCodeEnums;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    /**
     * 返回编码
     */
    private Integer code;

    /**
     * 编码描述
     */
    private String msg;

    /**
     * 业务数据
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseResult(){
        this.code = ResponseCodeEnums.SUCCESS.getCode();
        this.msg = ResponseCodeEnums.SUCCESS.getMsg();
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(T data) {
        this.data = data;
        return this;
    }

    public static ResponseResult okResult() {
        return new ResponseResult();
    }

    public static ResponseResult okResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, msg);
    }


    public static ResponseResult setResponseCodeEnum(ResponseCodeEnums enums){
        return okResult(enums.getCode(),enums.getMsg());
    }

    private static ResponseResult setResponseCodeEnum(ResponseCodeEnums enums, String msg){
        return okResult(enums.getCode(),msg);
    }

    public static ResponseResult okResult(Object data) {
        ResponseResult result = setResponseCodeEnum(ResponseCodeEnums.SUCCESS, ResponseCodeEnums.SUCCESS.getMsg());
        if(data!=null) {
            result.setData(data);
        }
        return result;
    }

    public ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }
    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }
    public static ResponseResult errorResult(ResponseCodeEnums enums){
        return setResponseCodeEnum(enums,enums.getMsg());
    }

    public static ResponseResult errorResult(ResponseCodeEnums enums, String msg){
        return setResponseCodeEnum(enums,msg);
    }






}
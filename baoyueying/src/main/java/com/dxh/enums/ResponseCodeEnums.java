package com.dxh.enums;

public enum ResponseCodeEnums {
    // 成功
    SUCCESS(200,"请求成功"),
    // 失败
    FAILED(500, "请求失败"),
    //
    NOT_FOUND(404, "接口不存在"),
    //
    SERVER_ERROR( 500 , " 服务器内部出错" );

    Integer code;

    String msg;

    ResponseCodeEnums(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

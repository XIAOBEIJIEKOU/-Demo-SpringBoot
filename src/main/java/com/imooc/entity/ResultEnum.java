package com.imooc.entity;

/**
 * @Author Zhuang YeFan
 * @Date
 * @Description
 * 定义返回结果和code之间的对应关系
 **/
public enum ResultEnum {

    UNKOWN_ERROR(1,"未知错误");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

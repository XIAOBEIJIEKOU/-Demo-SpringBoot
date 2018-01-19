package com.imooc.template;

import org.springframework.stereotype.Component;

/**
 * @Author Zhuang YeFan
 * @Date
 * @Description
 * 构造返回结果的统一格式
 **/

public class ResponseFormat<T> {

    /**
     * 成功或失败
     */
    private boolean isSuccess;

    /**
     * 成功或失败提示信息
     */
    private String msg;

    /**
     * 错误代码
     */
    private int errorCode;

    /**
     * 数据实体
     */
    private T data;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

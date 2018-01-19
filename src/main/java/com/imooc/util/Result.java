package com.imooc.util;

import com.imooc.template.ResponseFormat;

/**
 * @Author Zhuang YeFan
 * @Date
 * @Description
 * 用于创建不同的ResponseTemplate的构造方式，防止代码重复
 **/
public class Result {
    public static ResponseFormat success(Object o){
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setSuccess(true);
        responseFormat.setMsg("success");
        responseFormat.setErrorCode(0);
        responseFormat.setData(o);
        return responseFormat;
    }

    public static ResponseFormat error(String msg,int code){
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setSuccess(false);
        responseFormat.setMsg(msg);
        responseFormat.setErrorCode(code);
        responseFormat.setData(null);
        return responseFormat;
    }


}

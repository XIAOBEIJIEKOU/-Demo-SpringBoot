package com.imooc.exception;

import com.imooc.entity.ResultEnum;

/**
 * @Author Zhuang YeFan
 * @Date
 * @Description
 * spring只对RuntimeExcetion事务回滚
 **/
public class TestException extends RuntimeException {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TestException(){

    }

    public TestException(String msg){
        super(msg);
    }

    public TestException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = code;
    }
}

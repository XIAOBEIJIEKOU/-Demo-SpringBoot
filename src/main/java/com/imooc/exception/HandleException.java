package com.imooc.exception;

import com.imooc.template.ResponseFormat;
import com.imooc.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Zhuang YeFan
 * @Date
 * @Description
 * 捕获系统抛出的错误再次封装，提取有效数据按照ResponseFormat的格式返回
 **/
@ControllerAdvice
public class HandleException {

//    private static Logger logger = LoggerFactory.getLogger(TestException.class);

    @ExceptionHandler(value = TestException.class)
    @ResponseBody
    public ResponseFormat handleIllegalArgumentException(TestException e){
        return Result.error(e.getMessage(),e.getCode());
    }
}

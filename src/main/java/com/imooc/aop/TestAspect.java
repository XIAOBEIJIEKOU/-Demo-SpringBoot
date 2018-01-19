package com.imooc.aop;

import com.imooc.entity.ResultEnum;
import com.imooc.exception.TestException;
import com.imooc.template.ResponseFormat;
import com.imooc.util.Result;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author Zhuang YeFan
 * @Date 2017-12-29
 * @Description
 **/

@Aspect
@Component
public class TestAspect {

    private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    //  这种方法不行，参数类型不对
    String string = "execution(public * com.imooc.controller.*(..))" ;

    //  * 号表示的是这个类下的所有方法，只能有两个".."泛指参数，若不加则只能拦截不带参数的请求
    //  统一设置切点，防止代码重复
    @Pointcut("execution(public * com.imooc.controller.Test.*(..))")
    public void thisIsThePointToCut(){};

    @Before("thisIsThePointToCut()")
    public void doBefore(){
        logger.info("This is before!");
    }

    @After("thisIsThePointToCut()")
    public void doAfter(){
        logger.info("This is after!");
    }

    @AfterReturning(pointcut = "thisIsThePointToCut()",returning = "object")
    public void doAfterRuturning(Object object){
        logger.info("response={}",object);
    }

    @Before("execution(public * com.imooc.controller.Test.findOne(..))")
    public void checkParamOfFindOne() throws TestException{
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        if (request.getParameter("id").equals(null)){
            throw new TestException(ResultEnum.UNKOWN_ERROR);
        }
    }

}

package com.imooc.controller;

import com.imooc.aop.TestAspect;
import com.imooc.dao.TestRepository;
import com.imooc.entity.City;
import com.imooc.entity.ResultEnum;
import com.imooc.exception.TestException;
import com.imooc.template.ResponseFormat;
import com.imooc.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    //  测试在类中引用application.yml中的变量
    @Value("${developer}")
    private String developer;

    @GetMapping(value = "/test")
    public String test(){
        return "This is a test by "+developer;
    }

    //
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private City city;

    //  同时响应两个请求REST
    @RequestMapping(value = {"/hello","/hi"})
    public String doubleRest(){
        return "This is hello or hi";
    }

    //  测试PathVariable 和 RequestParam的区别
    @GetMapping(value = "testpath/{id}")
    public String getIdByPathVarrible(@PathVariable("id") String pathId){
        return pathId;
    }
    @GetMapping(value = "/testparam")
    public String getIdByParamter(@RequestParam(value = "id",defaultValue = "0",required = false) String paramId){
        return paramId;
    }

    //  测试 Jpa Repository 的方法
    @GetMapping(value = "jpa/findAll")
    public List<City> jpaRepository(){
        return testRepository.findAll();
    }

    /**
     * aop 在处理前check，若无参数传入则直接返回错误
     * 方法执行完之后返回前端统一的数据格式，避免重复代码的出现所以使用工具类约等于不同的构造方法，
     * 所以也可以在模板直接使用不同的构造方法实现这个功能
     * @param id
     * @return
     */
    @GetMapping(value = "jpa/findOne")
    public ResponseFormat<City> findOne(@RequestParam("id") Integer id){
        return Result.success(testRepository.getOne(id));
//        throw new TestException(ResultEnum.UNKOWN_ERROR);
    }

    @GetMapping(value = "jpa/findBy")
    public List<City> findBy(@RequestParam("contryCode") String contryCode){
        return testRepository.findByName(contryCode);
    }

    //  可以直接用对象做参数，防止后续修改的时候需要修改很多代码，只是传过来的变量名需与属性名一致才可以匹配
    @GetMapping(value = "addCity")
    public City addOne(City cityFromWeb){
        city.setName(cityFromWeb.getName());
        city.setCountryCode(cityFromWeb.getCountryCode());
        return testRepository.save(city);
    }
}

package com.imooc.dao;

import com.imooc.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author Zhuang YeFan
 * @Date 2017-12-27
 * @Description
 * 数据库接口，直接使用 JPA 调用数据库方法，无需实现类，直接调用
 * 类似于mybatis中的接口直接用 xml 配置sql语句实现数据库功能
 **/
public interface TestRepository extends JpaRepository<City, Integer> {

    //  扩展，只要方法名符合标准，自动生辰

    //  通过code查找
    public List<City> findByName(String name);
}

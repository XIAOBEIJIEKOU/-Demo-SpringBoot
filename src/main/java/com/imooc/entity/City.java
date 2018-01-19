package com.imooc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Source;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author Zhuang YeFan
 * @Date 2017-12-27
 * @Description 三个注解，无参构建方法，getter和setter
 **/

@Entity
@Component
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class City {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String countrycode;
    private String district;
    private Integer population;

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countrycode;
    }

    public void setCountryCode(String countryCode) {
        this.countrycode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "name: "+name;
    }
}

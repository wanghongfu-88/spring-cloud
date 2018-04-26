package com.spring.study.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanghongfu
 * @create 2018-01-23 23:19
 **/
@Configuration
public class Config {
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

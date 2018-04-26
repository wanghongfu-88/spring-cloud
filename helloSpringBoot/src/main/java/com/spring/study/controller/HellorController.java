package com.spring.study.controller;

import com.spring.study.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghongfu
 * @create 2018-01-23 22:58
 **/
@RestController
public class HellorController {

    @Autowired
    private Config config;

    @RequestMapping("/index/{id}")
    public String index(@PathVariable String id){
        return id+"=="+config.getName();
    }
}

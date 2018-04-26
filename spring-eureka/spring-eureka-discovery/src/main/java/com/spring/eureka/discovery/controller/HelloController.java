package com.spring.eureka.discovery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghongfu
 * @create 2018-01-24 21:53
 **/
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient disconveryClient;


    @RequestMapping("/hello")
    public String index(){
        ServiceInstance instance = disconveryClient.getLocalServiceInstance();
        logger.info("/hello, host:=="+instance.getHost()+",service_id:"+instance.getServiceId());
        logger.info("port:"+instance.getPort()+"===uri:"+instance.getUri());
        return "hello world,目前端口号为：" + port;
    }
}

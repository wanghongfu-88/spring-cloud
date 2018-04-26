package spring.eureka.feign.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.eureka.feign.customer.CustomerService;

import javax.annotation.Resource;

/**
 * 服务调用controller
 *
 * @author wanghongfu
 * @create 2018-01-26 9:47
 **/
@RestController
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("/hello")
    public String hello(){
        return customerService.hello();
    }
}

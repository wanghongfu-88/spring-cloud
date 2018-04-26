package spring.eureka.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.eureka.feign.service.CustomerService;

/**
 * 消费者
 *
 * @author wanghongfu
 * @create 2018-01-25 18:05
 **/
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/index")
    public String index(){
        return customerService.index();
    }
}

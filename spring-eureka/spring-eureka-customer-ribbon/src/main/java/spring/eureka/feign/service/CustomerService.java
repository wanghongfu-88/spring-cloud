package spring.eureka.feign.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * 服务提供者
 *
 * @author wanghongfu
 * @create 2018-01-26 11:04
 **/
@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用微服务方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback") // 容错
    public String index(){
        return restTemplate.getForEntity("http://hello-service/hello", String.class).toString();
    }

    public String fallback(){
        return "Index Fallback";
    }
}

package spring.eureka.feign.customer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 基于Feign服务消费类(Eureka+Feign：具有负载均衡)
 *
 * @author wanghongfu
 * @create 2018-01-26 9:41
 **/
@FeignClient(value="hello-service",fallback=CustomerHystiesService.class)
//@FeignClient(value = "hello-service")
public interface CustomerService {
    /**
     * 相当于在服务注册中心根据http://hello-service/hello，找到相应接口服务
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String hello();
}

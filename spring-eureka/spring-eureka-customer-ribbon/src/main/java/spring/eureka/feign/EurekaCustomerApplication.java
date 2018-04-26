package spring.eureka.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者(基于 restful+ribbon)调用消费者，ribbon具有负载均衡功能
 *
 * @author wanghongfu
 * @create 2018-01-25 18:00
 **/
@SpringBootApplication
@EnableDiscoveryClient //服务消费
@EnableHystrix //熔断
/*@EnableHystrixDashboard*/
public class EurekaCustomerApplication {

    @Bean
    @LoadBalanced  //开启负载均衡功能
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaCustomerApplication.class,args);
    }
}

package spring.eureka.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 服务消费者，基于Feign;Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 *
 * @author wanghongfu
 * @create 2018-01-26 0:05
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
/*@EnableCircuitBreaker //开启熔断器（feign 自带熔断）
@EnableHystrixDashboard //开启hystrixDashboard(熔断仪表盘),可以测试查看熔断信息 http://localhost:2222/hystrix
*/

public class EurekaFeginCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeginCustomerApplication.class,args);
    }
}

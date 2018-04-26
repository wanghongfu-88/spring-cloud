package spring.eureka.feign.customer;

/**
 * 服务熔断器接口
 *
 * @author wanghongfu
 * @create 2018-01-26 11:36
 **/
public class CustomerHystiesService implements CustomerService{
    @Override
    public String hello() {
        return "error pages";
    }
}

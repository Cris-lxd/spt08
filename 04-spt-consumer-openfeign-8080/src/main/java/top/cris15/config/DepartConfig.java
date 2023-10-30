package top.cris15.config;

import com.alibaba.nacos.shaded.io.grpc.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * date： 2023/10/10
 * time： 17:15
 * author： cris
 * description： 配置负载均衡策略
 **/


public class DepartConfig {

    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment e, LoadBalancerClientFactory factory){
        String name = e.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);     //获取微服务名称
        return new RandomLoadBalancer(factory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);          //从所有 provider 实例中找到指定名称的实例列表,进行负载均衡

    }

}

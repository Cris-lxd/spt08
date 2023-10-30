package top.cris15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import top.cris15.config.DepartConfig;

@SpringBootApplication
@EnableFeignClients
@LoadBalancerClients(defaultConfiguration = DepartConfig.class)
public class OpenFeignConsumer8080 {

	public static void main(String[] args) {
		SpringApplication.run(OpenFeignConsumer8080.class, args);
	}
}

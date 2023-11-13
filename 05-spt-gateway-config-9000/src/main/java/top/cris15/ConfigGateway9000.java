package top.cris15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ConfigGateway9000  {

	public static void main(String[] args) {
		SpringApplication.run(ConfigGateway9000.class, args);
	}

	//@Bean
	//KeyResolver userKeyResolver() {
	//	return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));		// user 作为限流键
	//}

	//@Bean
	//KeyResolver hostKeyResolver() {
	//	return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());		// user 作为限流键
	//}

	//@Bean
	//KeyResolver pathKeyResolver() {
	//	return exchange -> Mono.just(exchange.getRequest().getPath().value());		// user 作为限流键
	//}



}

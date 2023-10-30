package top.cris15.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * date： 2023/10/27
 * time： 08:03
 * author： cris
 * description：
 **/

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator tbRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("baidu_router",  ps -> ps.path("/bd").uri("https://www.baidu.com"))
                .route("jd_router", ps -> ps.path("/jd").uri("https://jd.com"))
                .build();

    }
}

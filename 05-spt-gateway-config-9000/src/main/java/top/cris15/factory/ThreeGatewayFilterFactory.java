package top.cris15.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * date： 2023/11/8
 * time： 11:08
 * author： cris
 * description：
 **/

@Component
@Slf4j
public class ThreeGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
       return (exchange, chain) -> {
            // pre-filter
           long start = System.currentTimeMillis();
           log.info(config.getName() + "-" + config.getValue());
           exchange.getAttributes().put("startTime",start);

           return chain.filter(exchange).then(
                   // post-filter
                   Mono.fromRunnable(()->{
                       log.info(config.getName() + "-" + config.getValue());
                   })
           );
        };
    }
}

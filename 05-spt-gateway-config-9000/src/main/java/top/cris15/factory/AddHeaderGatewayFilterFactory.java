package top.cris15.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * date： 2023/11/8
 * time： 11:08
 * author： cris
 * description：
 **/

@Component
public class AddHeaderGatewayFilterFactory  extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
       return (exchange, chain) -> {
            ServerHttpRequest changedRequest = exchange.getRequest().mutate().header(config.getName(), config.getValue()).build();      // 修改 request 内的值
            ServerWebExchange changedExchange = exchange.mutate().request(changedRequest).build();
            return chain.filter(changedExchange);
        };
    }
}

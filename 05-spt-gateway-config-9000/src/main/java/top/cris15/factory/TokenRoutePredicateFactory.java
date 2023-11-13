package top.cris15.factory;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * date： 2023/10/31
 * time： 07:19
 * author： cris
 * description：
 **/

@Component
public class TokenRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenRoutePredicateFactory.config> {

    public TokenRoutePredicateFactory() {
        super(config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(config config) {
        return exchange -> {
            MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
            List<String> values = params.get("token");
            return values.contains(config.getToken());
        };
    }


    @Data
    public static class config{

        private String token;
    }
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("token");
    }




}

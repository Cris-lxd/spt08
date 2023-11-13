package top.cris15.factory;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * date： 2023/10/31
 * time： 06:44
 * author： cris
 * description：用于自定义 auth 认证，username + password，结合 application 中的 auth 配置
 **/

@Component
public class AuthRoutePredicateFactory extends AbstractRoutePredicateFactory<AuthRoutePredicateFactory.config> {

    public AuthRoutePredicateFactory() {
        super(config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(config config) {
        return exchange -> {
            // 获取请求头
            HttpHeaders headers = exchange.getRequest().getHeaders();
            List<String> pwds = headers.get(config.getUsername());
            assert pwds != null;
            String[] values = pwds.get(0).split(",");
            // 判断请求头中是否存在指定的用户名
            return Arrays.stream(values).anyMatch(pwd -> pwd.equalsIgnoreCase(config.getPassword()));
        };
    }

    @Data
    public static class config{

        private String username;
        private String password;
    }

    // 指定读顺序
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("username","password");
    }


}



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
public class OneGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
       return (exchange, chain) -> {
            // pre-filter
           long start = System.currentTimeMillis();
           log.info(config.getName() + "-" + config.getValue() + "开始执行的时间：" + start);
           exchange.getAttributes().put("startTime",start);

           return chain.filter(exchange).then(
                   // post-filter
                   Mono.fromRunnable(()->{
                       long startTime = (long)exchange.getAttributes().get("startTime");
                       long endTime = System.currentTimeMillis();
                       long elapseTime = endTime - startTime;
                       log.info(config.getName() + "-" + config.getValue() + "开始完毕的时间：" + endTime);
                       log.info("执行用时" + elapseTime);
                   })
           );
        };
    }
}

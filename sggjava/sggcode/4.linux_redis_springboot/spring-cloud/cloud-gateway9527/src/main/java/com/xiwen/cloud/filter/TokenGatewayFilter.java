package com.xiwen.cloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/19 -19:47
 * @Version: 1.0
 */
//局部过滤器
@Component
public class TokenGatewayFilter extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
                String token = queryParams.getFirst("token");
                if (StringUtils.isEmpty(token)) {
                    System.out.println("没有携带token！");
                } else {
                    System.out.println("携带了token:" + token);
                }
                return chain.filter(exchange);
            }
        };
    }

    @Override
    public String name() {
        return "myFilter";
    }
}

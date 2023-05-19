package com.xiwen.cloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/19 -19:56
 * @Version: 1.0
 */
//@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(1);
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        List<String> list = headers.get("token");
        if (list != null) {
            String token = list.get(0);
            if (!StringUtils.isEmpty(token)) {
                System.out.println("全局过滤器token:" + token);
                return chain.filter(exchange);
            }
        }
        //没携带token
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    /**
     * int 值越小优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}

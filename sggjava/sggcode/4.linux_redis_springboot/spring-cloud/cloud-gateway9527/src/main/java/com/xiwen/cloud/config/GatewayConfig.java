package com.xiwen.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/19 -16:48
 * @Version: 1.0
 */

//gateway网关配置类配置方式(了解)
//@Component
public class GatewayConfig {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("xxx", aSyncBuilder -> {
            aSyncBuilder.path("/weathernew/**", "/static/**");
            return aSyncBuilder.uri("https://weathernew.pae.baidu.com");
        });
        return routes.build();
    }
}

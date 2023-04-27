package com.xiwen.ggkt.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -23:21
 * @Version: 1.0
 */
@SpringBootConfiguration
@EnableSwagger2 // 启用Swagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiwen")) // 扫描的包
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("硅谷课堂项目")
                .description("硅谷课堂项目学习项目")
//                .termsOfServiceUrl("http://www.baidu.com/")
                .version("1.0")
                .build();
    }
}
package com.xiwen.cloud.feign;

import com.xiwen.cloud.bean.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/17 -18:39
 * @Version: 1.0
 */
/*使用Hystrix进行服务的熔断
 * 1）、引入Hystrix的starter
 * 2）、开启xxx功能 ：@EnableCircuitBreaker * 3）
 *                  、@FeignClient(value="CLOUD-PROVIDER-MOVIE",fallback=指定这个接口的异常处理类（异常处理类必须实现这个接口）)
 */
// 指定服务
@FeignClient(value = "CLOUD-EUREKA-CLIENT-PROVIDER", fallback = MovieFeignClientExceptionHandler.class)
public interface MovieFeignClient {
    // 与远程请求的接口配置一模一样
    @GetMapping("/movie/info/{id}")
    Movie info(@PathVariable Integer id);
}

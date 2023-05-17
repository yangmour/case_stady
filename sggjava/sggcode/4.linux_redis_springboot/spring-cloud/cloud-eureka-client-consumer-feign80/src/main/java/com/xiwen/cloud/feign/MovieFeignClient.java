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
// 指定服务
@FeignClient("CLOUD-EUREKA-CLIENT-PROVIDER")
public interface MovieFeignClient {
    // 与远程请求的接口配置一模一样
    @GetMapping("/movie/info/{id}")
    Movie info(@PathVariable Integer id);
}

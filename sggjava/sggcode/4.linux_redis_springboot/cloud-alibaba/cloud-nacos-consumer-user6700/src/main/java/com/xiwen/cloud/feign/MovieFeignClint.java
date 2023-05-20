package com.xiwen.cloud.feign;

import com.xiwen.cloud.bean.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -14:02
 * @Version: 1.0
 */
@FeignClient(value = "cloud-nacos-provider-movie",fallback = MovieFeignClintExceptionHandler.class)
public interface MovieFeignClint {
    @GetMapping("/movie/info/{id}")
    Movie info(@PathVariable("id") Integer id);
}

package com.xiwen.cloud.feign;

import com.xiwen.cloud.bean.Movie;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/22 -20:10
 * @Version: 1.0
 */
@Component
public class MovieFeignClientFallbackFactory implements FallbackFactory<MovieFeignClint> {
    @Override
    public MovieFeignClint create(Throwable throwable) {
        return new MovieFeignClint() {
            @Override
            public Movie info(Integer id) {
                return new Movie(-1, "网络拥挤请重试！");
            }
        };
    }
}

package com.xiwen.cloud.feign;

import com.xiwen.cloud.bean.Movie;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/19 -14:24
 * @Version: 1.0
 */
@Component
public class MovieFeignClientExceptionHandler implements MovieFeignClient {

    @Override
    public Movie info(Integer id) {
        return new Movie(-1, "网络拥挤请重试！");
    }
}

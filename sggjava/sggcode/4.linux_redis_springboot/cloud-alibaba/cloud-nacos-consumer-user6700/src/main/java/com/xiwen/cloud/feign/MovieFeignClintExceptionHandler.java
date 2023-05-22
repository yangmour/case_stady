package com.xiwen.cloud.feign;

import com.xiwen.cloud.bean.Movie;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -14:12
 * @Version: 1.0
 */
//@Component
public class MovieFeignClintExceptionHandler implements MovieFeignClint {
    public Movie info(@PathVariable("id") Integer id) {
        return new Movie(-1, "测试降级处理");
    }
}

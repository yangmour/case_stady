package com.xiwen.cloud.controller;

import com.xiwen.cloud.bean.Movie;
import com.xiwen.cloud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -11:09
 * @Version: 1.0
 */
@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Value("${server.port}")
    private Integer port;

    @GetMapping("info/{id}")
    public Movie info(@PathVariable("id") Integer id) {
//        if (id==1){
//            throw new RuntimeException("测试降级处理，id为1手动抛出异常");
//        }
        System.out.println(port);
        return movieService.getById(id);
    }

}

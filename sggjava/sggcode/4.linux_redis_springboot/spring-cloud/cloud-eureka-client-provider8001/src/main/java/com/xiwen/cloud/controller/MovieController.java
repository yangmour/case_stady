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
 * @Create: 2023/05/17 -11:53
 * @Version: 1.0
 */
@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Value("${server.port}")
    public Integer port;

    @GetMapping("info/{id}")
    public Movie info(@PathVariable Integer id) {
        System.out.println(port);
        return movieService.getById(id);
    }
}

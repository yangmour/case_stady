package com.xiwen.cloud.controller;

import com.xiwen.cloud.bean.Movie;
import com.xiwen.cloud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("info/{id}")
    public Movie info(@PathVariable("id") Integer id) {
        return movieService.getById(id);
    }

}

package com.xiwen.cloud.service.impl;

import com.xiwen.cloud.bean.Movie;
import com.xiwen.cloud.mapper.MovieMapper;
import com.xiwen.cloud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -11:07
 * @Version: 1.0
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Movie getById(Integer id) {
        return movieMapper.getById(id);
    }
}

package com.xiwen.cloud.mapper;

import com.xiwen.cloud.bean.Movie;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -11:05
 * @Version: 1.0
 */
@Repository
public interface MovieMapper {

    @Select("select mid id,movie_name movieName from movie where mid=#{id}")
    Movie getById(Integer id);
}

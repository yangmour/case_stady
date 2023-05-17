package com.xiwen.cloud.mapper;

import com.xiwen.cloud.bean.Movie;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/17 -11:48
 * @Version: 1.0
 */
@Repository
public interface MovieMapper {
    @Select("select mid,movie_name movieName from movie where mid = #{id}")
    Movie getById(Integer mid);
}

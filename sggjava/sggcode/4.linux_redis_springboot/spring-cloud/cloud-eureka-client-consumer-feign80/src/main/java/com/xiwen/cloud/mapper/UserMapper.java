package com.xiwen.cloud.mapper;

import com.xiwen.cloud.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/17 -14:26
 * @Version: 1.0
 */
@Repository
public interface UserMapper {
    @Select("select * from user where uid = #{id}")
    User getById(Integer uid);
}

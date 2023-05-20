package com.xiwen.cloud.mapper;

import com.xiwen.cloud.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/20 -11:39
 * @Version: 1.0
 */
@Repository
public interface UserMapper {

    @Select("select uid id,username,age,email,qq,gender from user where uid=#{id}")
    User getById(Integer id);
}

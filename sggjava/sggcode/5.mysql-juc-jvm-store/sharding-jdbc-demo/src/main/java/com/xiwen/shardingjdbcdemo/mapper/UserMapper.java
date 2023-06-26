package com.xiwen.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiwen.shardingjdbcdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/26 -18:35
 * @Version: 1.0
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

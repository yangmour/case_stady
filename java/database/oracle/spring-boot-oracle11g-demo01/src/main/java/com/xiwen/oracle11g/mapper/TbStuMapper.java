package com.xiwen.oracle11g.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiwen.oracle11g.entity.TbStu;
import org.springframework.stereotype.Repository;

/**
 * @author 希文
 * @description 针对表【TB_STU】的数据库操作Mapper
 * @createDate 2023-07-09 16:58:53
 * @Entity generator.entity.TbStu
 */
@Repository
public interface TbStuMapper extends BaseMapper<TbStu> {

    TbStu cs();
}





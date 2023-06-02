package com.atguigu.syt.cmn.mapper;


import com.atguigu.syt.model.cmn.DictType;
import com.atguigu.syt.vo.cmn.DictTypeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xiwen
 * @since 2023-05-31
 */
@Repository
public interface DictTypeMapper extends BaseMapper<DictType> {

    List<DictTypeVo> findAll();

}

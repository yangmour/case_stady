package com.atguigu.syt.cmn.service;

import com.atguigu.syt.model.cmn.Dict;
import com.atguigu.syt.vo.cmn.DictTypeVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiwen
 * @since 2023-05-31
 */
public interface DictService extends IService<Dict> {

    List<DictTypeVo> findAll();

    String getHostName(Long dictTypeId, String value);

    List<Dict> getDictListByDictTypeId(Long dictTypeId);
}

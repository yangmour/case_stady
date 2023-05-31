package com.atguigu.syt.cmn.service.impl;

import com.atguigu.syt.cmn.mapper.DictMapper;
import com.atguigu.syt.cmn.mapper.DictTypeMapper;
import com.atguigu.syt.cmn.service.DictService;
import com.atguigu.syt.model.cmn.Dict;
import com.atguigu.syt.model.cmn.DictType;
import com.atguigu.syt.vo.cmn.DictTypeVo;
import com.atguigu.syt.vo.cmn.DictVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiwen
 * @since 2023-05-31
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    private DictTypeMapper dictTypeMapper;

    @Override
    public List<DictTypeVo> findAll() {
        List<DictType> dictTypes = dictTypeMapper.selectList(null);
        List<Dict> dicts = baseMapper.selectList(null);

        List<DictTypeVo> dictTypeVoList = dictTypes.stream()
                .map(item -> {
                    DictTypeVo dictTypeVo = new DictTypeVo();
                    dictTypeVo.setId("parent-" + item.getId());
                    dictTypeVo.setName(item.getName());

                    List<DictVo> dictVoList = dicts.stream()
                            .map(dict -> {
                                DictVo dictVo = new DictVo();
                                dictVo.setId("children-" + dict.getId());
                                dictVo.setName(dict.getName());
                                dictVo.setValue(dict.getValue());
                                return dictVo;
                            })
                            .collect(Collectors.toList());

                    dictTypeVo.setChildren(dictVoList);
                    return dictTypeVo;
                })
                .collect(Collectors.toList());


        return dictTypeVoList;
    }
}

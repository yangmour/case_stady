package com.atguigu.syt.cmn.service.impl;

import com.atguigu.syt.cmn.mapper.DictMapper;
import com.atguigu.syt.cmn.mapper.DictTypeMapper;
import com.atguigu.syt.cmn.service.DictService;
import com.atguigu.syt.model.cmn.Dict;
import com.atguigu.syt.model.cmn.DictType;
import com.atguigu.syt.vo.cmn.DictTypeVo;
import com.atguigu.syt.vo.cmn.DictVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public String getHostName(Long dictTypeId, String value) {
        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.eq("dict_type_id", dictTypeId);
        dictQueryWrapper.eq("value", value);
        Dict dict = baseMapper.selectOne(dictQueryWrapper);
        return dict.getName();
    }

    public List<DictTypeVo> findAll() {
        return dictTypeMapper.findAll();
    }

    //    @Override
    public List<DictTypeVo> findAll1() {
        List<DictType> dictTypes = dictTypeMapper.selectList(null);
        List<Dict> dicts = baseMapper.selectList(null);

        List<DictTypeVo> dictTypeVoList = dictTypes.stream()
                .map(dictType -> {
                    DictTypeVo dictTypeVo = new DictTypeVo();
                    dictTypeVo.setId("parent-" + dictType.getId());
                    dictTypeVo.setName(dictType.getName());

                    List<DictVo> dictVoList = dicts.stream()
                            .filter(dict -> dict.getDictTypeId().longValue() == dictType.getId().longValue())
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

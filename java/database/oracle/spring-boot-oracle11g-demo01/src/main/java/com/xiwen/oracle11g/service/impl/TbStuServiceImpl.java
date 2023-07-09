package com.xiwen.oracle11g.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwen.oracle11g.service.TbStuService;
import com.xiwen.oracle11g.entity.TbStu;
import com.xiwen.oracle11g.mapper.TbStuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 希文
 * @description 针对表【TB_STU】的数据库操作Service实现
 * @createDate 2023-07-09 16:58:53
 */
@Service
public class TbStuServiceImpl extends ServiceImpl<TbStuMapper, TbStu>
        implements TbStuService {

    @Autowired
    private TbStuMapper tbStuMapper;

    @Override
    public TbStu cs() {
        return tbStuMapper.cs();
    }
}





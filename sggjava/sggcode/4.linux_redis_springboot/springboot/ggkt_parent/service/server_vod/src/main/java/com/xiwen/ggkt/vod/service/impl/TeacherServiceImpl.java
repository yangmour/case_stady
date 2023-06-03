package com.xiwen.ggkt.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwen.ggkt.model.vod.Teacher;
import com.xiwen.ggkt.vo.vod.TeacherQueryVo;
import com.xiwen.ggkt.vod.mapper.TeacherMapper;
import com.xiwen.ggkt.vod.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author xw
 * @since 2023-04-26
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public  Page<Teacher> findQueryPage(Integer pageNum, Integer pageSize, TeacherQueryVo teacherQueryVo) {

        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();

        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like(Teacher::getName, name);
        }
        if (!StringUtils.isEmpty(level)) {
            queryWrapper.eq(Teacher::getLevel, level);
        }
        if (!StringUtils.isEmpty(joinDateBegin)) {
            queryWrapper.ge(Teacher::getLevel, level);
        }
        if (!StringUtils.isEmpty(joinDateEnd)) {
            queryWrapper.le(Teacher::getJoinDate, joinDateEnd);
        }
        Page<Teacher> page = new Page<>(pageNum, pageSize);
        //todo
        Page<Teacher> teacherPage = baseMapper.selectPage(page, queryWrapper);
        return teacherPage;
    }
}

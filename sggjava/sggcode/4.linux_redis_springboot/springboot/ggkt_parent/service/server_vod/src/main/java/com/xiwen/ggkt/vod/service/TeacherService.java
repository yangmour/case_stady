package com.xiwen.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiwen.ggkt.model.vod.Teacher;
import com.xiwen.ggkt.vo.vod.TeacherQueryVo;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author xw
 * @since 2023-04-26
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> findQueryPage(Integer pageNum, Integer pageSize, TeacherQueryVo teacherQueryVo);
}

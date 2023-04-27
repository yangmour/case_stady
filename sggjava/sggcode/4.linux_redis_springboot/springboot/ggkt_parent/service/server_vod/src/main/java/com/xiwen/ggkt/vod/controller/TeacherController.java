package com.xiwen.ggkt.vod.controller;


import com.xiwen.ggkt.model.vod.Teacher;
import com.xiwen.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author xw
 * @since 2023-04-26
 */
@Api(tags = "教师管理接口")
@RestController
@RequestMapping("/vod/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("查询所有教师")
    @GetMapping("findAll")
    public List<Teacher> findAll() {
        List<Teacher> list = teacherService.list();
        System.out.println(list);
        return list;
    }

    @ApiOperation("根据id逻辑删除教师")
    @DeleteMapping("/{id}")
    public boolean removeById(
            @ApiParam(name = "id", value = "ID") @PathVariable Integer id) {
        return teacherService.removeById(id);

    }
}


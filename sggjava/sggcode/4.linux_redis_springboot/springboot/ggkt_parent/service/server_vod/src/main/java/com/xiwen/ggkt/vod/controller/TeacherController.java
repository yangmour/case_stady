package com.xiwen.ggkt.vod.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiwen.ggkt.exception.GuiGuException;
import com.xiwen.ggkt.model.vod.Teacher;
import com.xiwen.ggkt.utils.R;
import com.xiwen.ggkt.vo.vod.TeacherQueryVo;
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
    public R findAll() {
        List<Teacher> list = teacherService.list();
        return R.ok(list);
    }

    @ApiOperation("根据id逻辑删除教师")
    @DeleteMapping("/{id}")
    public R removeById(
            @ApiParam(name = "id", value = "ID") @PathVariable Integer id) {
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        }
        return R.fail();
    }

    @ApiOperation("分页查询")
    @PostMapping("findQueryPage/{pageNum}/{pageSize}")
    public R findQueryPage(
            @ApiParam("页码") @PathVariable Integer pageNum,
            @ApiParam("页数") @PathVariable Integer pageSize,
            @ApiParam("查询条件对象") @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            throw new GuiGuException(401,"出现异常");
        }
        Page<Teacher> teacherPage = teacherService.findQueryPage(pageNum, pageSize, teacherQueryVo);
        return R.ok(teacherPage);
    }

    @ApiOperation("新增")
    @PostMapping("saveTeacher")
    public R saveTeacher(@ApiParam("添加的对象") @RequestBody Teacher teacher) {
        boolean flag = teacherService.save(teacher);
        if (flag) {
            return R.ok();
        }
        return R.fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public R batchRemove(@RequestBody List<Long> ids) {
        boolean flag = teacherService.removeByIds(ids);

        if (flag) {
            return R.ok();
        }
        return R.fail();
    }

    @ApiOperation("根据id获取")
    @GetMapping("getTeacherById/{id}")
    public R getTeacherById(@ApiParam("查询的id") @PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return R.ok(teacher);
    }

    @ApiOperation("修改老师信息")
    @PutMapping("updateTeacher")
    public R updateTeacher(@ApiParam("修改的对象") @RequestBody Teacher teacher) {
        boolean flag = teacherService.updateById(teacher);
        if (flag) {
            return R.ok();
        }
        return R.fail();
    }
}


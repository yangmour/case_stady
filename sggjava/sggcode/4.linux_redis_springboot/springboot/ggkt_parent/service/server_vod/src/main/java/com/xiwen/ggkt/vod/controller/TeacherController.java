package com.xiwen.ggkt.vod.controller;


import com.xiwen.ggkt.model.vod.Teacher;
import com.xiwen.ggkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author xw
 * @since 2023-04-26
 */
@RestController
@RequestMapping("/vod/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("findAll")
    public List<Teacher> findAll() {
        List<Teacher> list = teacherService.list();
        System.out.println(list);
        return list;
    }
}


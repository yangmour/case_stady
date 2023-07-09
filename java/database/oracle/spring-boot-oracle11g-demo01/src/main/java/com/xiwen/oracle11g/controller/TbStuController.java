package com.xiwen.oracle11g.controller;

import com.xiwen.oracle11g.entity.TbStu;
import com.xiwen.oracle11g.service.TbStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/09 -16:59
 * @Version: 1.0
 */
@RestController
@RequestMapping("/cs")
public class TbStuController {

    @Autowired
    private TbStuService tbStuService;

    @GetMapping("findAll")
    public Object findAll() {
        return tbStuService.list();
    }

    @GetMapping("save")
    public Object save() {
        return tbStuService.save(new TbStu(null, "张三", 50));
    }

    @GetMapping("update")
    public Object update() {
        return tbStuService.updateById(new TbStu(20L, "李四", 50));
    }

    @GetMapping("cs")
    public Object cs() {
        TbStu tb_stu = tbStuService.cs();
        return tb_stu;
    }
}

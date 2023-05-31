package com.atguigu.syt.cmn.controller.admin;


import com.atguigu.common.util.result.Result;
import com.atguigu.syt.cmn.service.DictService;
import com.atguigu.syt.vo.cmn.DictTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiwen
 * @since 2023-05-31
 */
@RestController
@RequestMapping("/cmn/dict")
public class AdminDictController {

    @Autowired
    private DictService dictService;

    @GetMapping("findAll")
    public Result<Object> findAll() {
        List<DictTypeVo> dictTypeVoList = dictService.findAll();
        return Result.ok(dictTypeVoList);
    }
}


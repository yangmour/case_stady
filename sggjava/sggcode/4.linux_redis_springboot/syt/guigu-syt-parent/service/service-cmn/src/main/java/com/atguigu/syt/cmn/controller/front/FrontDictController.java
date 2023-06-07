package com.atguigu.syt.cmn.controller.front;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.cmn.service.DictService;
import com.atguigu.syt.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/07 -15:59
 * @Version: 1.0
 */
@Api(tags = "数据字典接口")
@RestController
@RequestMapping("/front/cmn/dict")
//@CrossOrigin //跨域 局部的和全局的只能配置一个，如果两个都配置了还会有跨域问题
public class FrontDictController {
    @Autowired
    private DictService dictService;

    @ApiOperation("获取市区医院级别")
    @RequestMapping("getDictList/{dictTypeId}")
    public Result<Object> getDictList(@PathVariable Long dictTypeId) {
        List<Dict> dicts = dictService.getDictListByDictTypeId(dictTypeId);
        return Result.ok(dicts);
    }

}

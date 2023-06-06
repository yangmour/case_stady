package com.atguigu.syt.cmn.controller.inner;

import com.atguigu.syt.cmn.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/05 -16:46
 * @Version: 1.0
 */

@Api(tags = "数据字典")
@RestController
@RequestMapping("/inner/cmn/dict")
public class InnerDictController {

    @Autowired
    private DictService dictService;

    @ApiOperation(value = "获取数据字典名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictTypeId", value = "字典类型id", required = true),
            @ApiImplicitParam(name = "value", value = "字典值", required = true)})
    @GetMapping(value = "/getName/{dictTypeId}/{value}")
    public String getHostName(@PathVariable Long dictTypeId, @PathVariable String value) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return dictService.getHostName(dictTypeId, value);

    }

}

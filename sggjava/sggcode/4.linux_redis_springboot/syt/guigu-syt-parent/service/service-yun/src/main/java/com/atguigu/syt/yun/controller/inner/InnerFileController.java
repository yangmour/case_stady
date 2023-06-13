package com.atguigu.syt.yun.controller.inner;

import com.atguigu.syt.yun.service.FrontFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/13 -15:35
 * @Version: 1.0
 */

@Api(tags = "阿里云文件管理")
@RestController
@RequestMapping("/inner/yun/file")
public class InnerFileController {

    @Autowired
    private FrontFileService frontFileService;

    @ApiOperation(value = "获取图片预览Url")
    @ApiImplicitParam(name = "objectName", value = "文件名", required = true)
    @GetMapping("getPreviewUrl")
    public String getPreviewUrl(@RequestParam("objectName") String ObjectName) {
        return frontFileService.getPreviewUrl(ObjectName);
    }

}

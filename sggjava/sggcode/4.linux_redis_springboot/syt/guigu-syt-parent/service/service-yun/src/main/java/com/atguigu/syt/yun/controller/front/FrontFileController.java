package com.atguigu.syt.yun.controller.front;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.yun.service.FrontFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/12 -23:13
 * @Version: 1.0
 */

@Api(tags = "阿里云文件管理")
@RestController
@RequestMapping("/front/yun/file")
public class FrontFileController {

    @Autowired
    private FrontFileService frontFileService;

    /**
     * 文件上传
     */
    @ApiOperation("文件上传")
    @ApiImplicitParam(name = "file", value = "上传文件", required = true)
    @PostMapping("/auth/upload")
    public Result<Object> upload(MultipartFile file) {

        Map<String, String> map = frontFileService.upload(file);
        return Result.ok(map);
    }

}

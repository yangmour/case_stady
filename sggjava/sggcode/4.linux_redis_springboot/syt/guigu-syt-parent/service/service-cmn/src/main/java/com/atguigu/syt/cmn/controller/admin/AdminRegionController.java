package com.atguigu.syt.cmn.controller.admin;


import com.alibaba.excel.EasyExcel;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.cmn.service.RegionService;
import com.atguigu.syt.vo.cmn.RegionExcelVo;
import com.atguigu.syt.vo.cmn.RegionVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
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
@RequestMapping("/admin/cmn/region")
@Slf4j
public class AdminRegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("findRegionListByParentCode/{parentCode}")
    public Result<Object> findRegionListByParentCode(@PathVariable String parentCode) {

        List<RegionVo> regionVoList = regionService.getByParentCode(parentCode);
        return Result.ok(regionVoList);
    }

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link RegionVo}
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        try {
            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("地区管理", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

            List<RegionExcelVo> regionVoList = regionService.findRegionExcelVoList();
            EasyExcel.write(response.getOutputStream(), RegionExcelVo.class).sheet("模板").doWrite(regionVoList);
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            response.reset();
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print("导出失败！");
        }
    }

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link RegionVo}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link RegionVoListener}
     * <p>3. 直接读即可
     */
    @PostMapping("upload")
    @ResponseBody
    public Result upload(MultipartFile file) throws IOException {
        regionService.importData(file);
        return Result.ok();
    }

}


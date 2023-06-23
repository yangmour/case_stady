package com.atguigu.syt.statistics.controller.admin;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.statistics.service.StatisticsService;
import com.atguigu.syt.vo.statistics.OrderCountQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/23 -11:25
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/statics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("getCountMap")
    public Result<Object> getCountMap(@RequestBody OrderCountQueryVo orderCountQueryVo) {
        Map<String, Object> map = statisticsService.getCountMap(orderCountQueryVo);
        return Result.ok(map);
    }
}

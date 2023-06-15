package com.atguigu.syt.hosp.controller.inner;

import com.atguigu.syt.hosp.service.ScheduleService;
import com.atguigu.syt.vo.hosp.ScheduleOrderVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -21:37
 * @Version: 1.0
 */

@Api(tags = "医院接口-供其他微服务远程调用")
@RestController
@RequestMapping("/inner/hosp/hospital")
public class InnerScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("getScheduleInfo/{scheduleId}")
    public ScheduleOrderVo getScheduleInfo(@PathVariable("scheduleId") String scheduleId) {
        return scheduleService.getScheduleOrderVo(scheduleId);
    }
}

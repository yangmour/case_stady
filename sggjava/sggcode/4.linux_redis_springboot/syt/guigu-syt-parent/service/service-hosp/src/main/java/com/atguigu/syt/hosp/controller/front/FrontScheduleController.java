package com.atguigu.syt.hosp.controller.front;

import com.atguigu.common.service.utils.AuthContextHolder;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.hosp.service.ScheduleService;
import com.atguigu.syt.model.hosp.Schedule;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -08:52
 * @Version: 1.0
 */
@Api(tags = "排班")
@RestController
@RequestMapping("/front/hosp/schedule")
@RequiredArgsConstructor
public class FrontScheduleController {

    private final AuthContextHolder authContextHolder;
    private final ScheduleService scheduledService;

    @GetMapping("getBookingScheduleRule/{pageNum}/{pageSize}/{hoscode}/{depcode}")
    public Result<Object> getBookingScheduleRule(@PathVariable Integer pageNum,
                                                 @PathVariable Integer pageSize,
                                                 @PathVariable String hoscode,
                                                 @PathVariable String depcode,
                                                 HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) {
        // 认证
        authContextHolder.checkAuth(httpServletRequest, httpServletResponse);

        Map<String, Object> map = scheduledService.getBookingScheduleRule(pageNum, pageSize, hoscode, depcode);
        return Result.ok(map);
    }

    @GetMapping("getScheduleList/{hoscode}/{depcode}/{workDate}")
    public Result<Object> getScheduleList(@PathVariable String hoscode,
                                          @PathVariable String depcode,
                                          @PathVariable String workDate,
                                          HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        authContextHolder.checkAuth(httpServletRequest, httpServletResponse);

        List<Schedule> scheduleDetail = scheduledService.getScheduleDetail(hoscode, depcode, workDate);
        return Result.ok(scheduleDetail);
    }

    @GetMapping("getScheduleDetail/{scheduleId}")
    public Result<Object> getScheduleDetail(@PathVariable String scheduleId,
                                            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        Schedule schedule = scheduledService.getScheduleDetailById(scheduleId);
        return Result.ok(schedule);
    }

}

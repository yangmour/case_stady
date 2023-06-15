package com.atguigu.syt.hosp.client;

import com.atguigu.syt.hosp.client.callback.ScheduleFeignClientCallback;
import com.atguigu.syt.vo.hosp.ScheduleOrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -22:55
 * @Version: 1.0
 */
@FeignClient(value = "service-hosp",contextId = "hospFeignClient",path = "/inner/hosp/hospital",fallback = ScheduleFeignClientCallback.class)
public interface ScheduleFeignClient {
    @GetMapping("getScheduleInfo/{scheduleId}")
    ScheduleOrderVo getScheduleInfo(@PathVariable("scheduleId") String scheduleId);
}

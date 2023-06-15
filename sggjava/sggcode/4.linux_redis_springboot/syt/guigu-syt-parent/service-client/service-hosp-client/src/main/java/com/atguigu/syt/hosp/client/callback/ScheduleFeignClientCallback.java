package com.atguigu.syt.hosp.client.callback;

import com.atguigu.syt.hosp.client.ScheduleFeignClient;
import com.atguigu.syt.vo.hosp.ScheduleOrderVo;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -22:57
 * @Version: 1.0
 */
@Component
public class ScheduleFeignClientCallback implements ScheduleFeignClient {
    @Override
    public ScheduleOrderVo getScheduleInfo(String scheduleId) {
        return null;
    }
}

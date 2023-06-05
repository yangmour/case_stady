package com.atguigu.syt.hosp.service;

import com.atguigu.syt.model.hosp.Schedule;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -16:57
 * @Version: 1.0
 */
public interface ScheduleService {
    void saveSchedule(Map<String, Object> scheduleMap);

    Page<Schedule> findSchedule(Map<String, Object> departmentMap);

    void scheduleRemove(Map<String, Object> scheduleMap);
}

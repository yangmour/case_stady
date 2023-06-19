package com.atguigu.syt.hosp.service;

import com.atguigu.syt.model.hosp.Schedule;
import com.atguigu.syt.vo.hosp.ScheduleOrderVo;
import com.atguigu.syt.vo.order.OrderMqVo;
import org.springframework.data.domain.Page;

import java.util.List;
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

    Map<String, Object> getScheduleRule(String hoscode, String depCode, Integer pageNum, Integer pageSize);

    List<Schedule> getScheduleDetail(String hoscode, String depcode, String workDate);

    Map<String, Object> getBookingScheduleRule(Integer pageNum, Integer pageSize, String hoscode, String depcode);

    Schedule getScheduleDetailById(String scheduleId);

    ScheduleOrderVo getScheduleOrderVo(String scheduleId);

    void updateOrderInfo(OrderMqVo orderMqVo);
}

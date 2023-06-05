package com.atguigu.syt.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.syt.hosp.repository.ScheduleRepository;
import com.atguigu.syt.hosp.service.ScheduleService;
import com.atguigu.syt.model.hosp.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -16:58
 * @Version: 1.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;


    @Override
    public void saveSchedule(Map<String, Object> scheduleMap) {
        String toJSONString = JSONObject.toJSONString(scheduleMap);
        Schedule schedule = JSONObject.parseObject(toJSONString, Schedule.class);
        Schedule hosScheduleId = scheduleRepository.findByHoscodeAndDepcodeAndHosScheduleId(schedule.getHoscode(), schedule.getDepcode(), schedule.getHosScheduleId());
        if (hosScheduleId != null) {
            schedule.setId(hosScheduleId.getId());
            scheduleRepository.save(schedule);
        } else {
            scheduleRepository.save(schedule);
        }
    }

    @Override
    public Page<Schedule> findSchedule(Map<String, Object> departmentMap) {

        String hoscode = (String) departmentMap.get("hoscode");
        Integer page = Integer.parseInt((String) departmentMap.get("page"));
        Integer limit = Integer.parseInt((String) departmentMap.get("limit"));

        Schedule schedule = new Schedule();
        schedule.setHoscode(hoscode);
        Example<Schedule> example = Example.of(schedule);

        PageRequest pageable = PageRequest.of(page - 1, limit);

        return scheduleRepository.findAll(example, pageable);
    }

    @Override
    public void scheduleRemove(Map<String, Object> scheduleMap) {
        String hoscode = (String) scheduleMap.get("hoscode");
        String hosScheduleId = (String) scheduleMap.get("hosScheduleId");

        Schedule byHoscodeAndHosScheduleId = scheduleRepository.findByHoscodeAndHosScheduleId(hoscode, hosScheduleId);
        scheduleRepository.delete(byHoscodeAndHosScheduleId);

    }
}

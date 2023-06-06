package com.atguigu.syt.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.syt.hosp.repository.ScheduleRepository;
import com.atguigu.syt.hosp.service.ScheduleService;
import com.atguigu.syt.hosp.utils.DateUtil;
import com.atguigu.syt.model.hosp.Schedule;
import com.atguigu.syt.vo.hosp.ScheduleRuleVo;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -16:58
 * @Version: 1.0
 */
@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


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

    @Override
    public Map<String, Object> getScheduleRule(String hoscode, String depCode, Integer pageNum, Integer pageSize) {
        //分页
        Criteria where = Criteria.where("hoscode").is(hoscode).and("depcode").is(depCode);

        Aggregation aggregation = Aggregation.newAggregation(
                //条件
                Aggregation.match(where),
                //分组
                Aggregation.group("workDate").first("workDate").as("workDate")
                        //聚合
                        .sum("reservedNumber").as("reservedNumber")
                        .sum("availableNumber").as("availableNumber"),
                //排序
                Aggregation.sort(Sort.by("workDate").ascending()),
                //分页
                Aggregation.skip((pageNum - 1) * pageSize.longValue()), Aggregation.limit(pageSize));
        AggregationResults<ScheduleRuleVo> aggregationResults = mongoTemplate.aggregate(aggregation, Schedule.class, ScheduleRuleVo.class);
        List<ScheduleRuleVo> scheduleRuleVos = aggregationResults.getMappedResults();

        scheduleRuleVos.forEach(scheduleRuleVo -> {
            String dayOfWeek = DateUtil.getDayOfWeek(new DateTime(scheduleRuleVo.getWorkDate()));
            scheduleRuleVo.setDayOfWeek(dayOfWeek);
        });

        log.info("ScheduleServiceImpl.getScheduleRule执行完毕,结果:{}", scheduleRuleVos);
        //总条数
        AggregationResults<ScheduleRuleVo> aggregationResults2 = mongoTemplate.aggregate(Aggregation.newAggregation(
                //条件
                Aggregation.match(where),
                //分组
                Aggregation.group("workDate")), Schedule.class, ScheduleRuleVo.class);
        int total = aggregationResults2.getMappedResults().size();

        HashMap<String, Object> map = new HashMap<>();
        map.put("list", scheduleRuleVos);
        map.put("total", total);
        return map;
    }

    @Override
    public List<Schedule> getScheduleDetail(String hoscode, String depcode, String workDate) {

        Schedule query = new Schedule();
        query.setHoscode(hoscode);
        query.setDepcode(depcode);
        query.setWorkDate(new DateTime(workDate).toDate());

        Example<Schedule> example = Example.of(query);

        return scheduleRepository.findAll(example);
    }
}

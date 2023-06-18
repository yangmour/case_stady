package com.atguigu.syt.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.syt.hosp.repository.DepartmentRepository;
import com.atguigu.syt.hosp.repository.HospitalRepository;
import com.atguigu.syt.hosp.repository.ScheduleRepository;
import com.atguigu.syt.hosp.service.ScheduleService;
import com.atguigu.syt.hosp.utils.DateUtil;
import com.atguigu.syt.model.hosp.BookingRule;
import com.atguigu.syt.model.hosp.Department;
import com.atguigu.syt.model.hosp.Hospital;
import com.atguigu.syt.model.hosp.Schedule;
import com.atguigu.syt.vo.hosp.BookingScheduleRuleVo;
import com.atguigu.syt.vo.hosp.ScheduleOrderVo;
import com.atguigu.syt.vo.hosp.ScheduleRuleVo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

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
                        .sum("reservedNumber").as("reservedNumber").sum("availableNumber").as("availableNumber"),
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
        List<Schedule> scheduleList = scheduleRepository.findAll(example);

        scheduleList.forEach(schedule -> {
            schedule.getParam().put("id", schedule.getId().toString());
            System.out.println("-------------------" + schedule.getParam());

        });
        return scheduleList;
    }

    @Override
    public Map<String, Object> getBookingScheduleRule(Integer pageNum, Integer pageSize, String hoscode, String depcode) {
        //获取医院
        Hospital hospital = hospitalRepository.findByHoscode(hoscode);
        BookingRule bookingRule = hospital.getBookingRule();

        // 封装分页可预约时间
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Date> page = getDateList(pageNum, pageSize, bookingRule);
        long pages = page.getPages();

        List<Date> records = page.getRecords();

        MatchOperation match = Aggregation.match(Criteria.where("hoscode").is(hoscode).and("depcode").is(depcode).and("workDate").in(records));
        GroupOperation group = Aggregation.group("workDate").first("workDate").as("workDate")
                .sum("availableNumber").as("availableNumber");
        SortOperation sort = Aggregation.sort(Sort.Direction.ASC, "workDate");
        // 封装预约日期数据、如日期、周几、是否有号等
        Aggregation aggregation = Aggregation.newAggregation(
                match,
                group,
                sort
        );
        AggregationResults<BookingScheduleRuleVo> aggregate = mongoTemplate.aggregate(aggregation, Schedule.class, BookingScheduleRuleVo.class);

        //转成可以展示的map
        List<BookingScheduleRuleVo> mappedResults = aggregate.getMappedResults();

        Map<Date, BookingScheduleRuleVo> dateBookingScheduleRuleVoMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(mappedResults)) {
            dateBookingScheduleRuleVoMap = mappedResults.stream().collect(Collectors.toMap(BookingScheduleRuleVo::getWorkDate, o -> o));
        }

        List<BookingScheduleRuleVo> bookingScheduleRuleVoList = new ArrayList<>();

        for (int i = 0; i < records.size(); i++) {
            Date date = records.get(i);
            BookingScheduleRuleVo bookingScheduleRuleVo = dateBookingScheduleRuleVoMap.get(date);
            if (bookingScheduleRuleVo == null) {
                bookingScheduleRuleVo = new BookingScheduleRuleVo();
                bookingScheduleRuleVo.setAvailableNumber(-1);
                bookingScheduleRuleVo.setWorkDate(date);
            }

            bookingScheduleRuleVo.setWorkDateMd(date);
            bookingScheduleRuleVo.setDayOfWeek(DateUtil.getDayOfWeek(new DateTime(date)));
            bookingScheduleRuleVo.setStatus(0);

            // 第一页的第一天如果过了挂号时间就停止挂号，特殊处理
            if (pageNum == 1 && i == 0) {
                DateTime dateTime = parseDateToDateTime(date, bookingRule.getStopTime());
                if (dateTime.isBeforeNow()) {
                    bookingScheduleRuleVo.setStatus(-1);
                }
            }

            // 最后1页的最后1天，特殊处理
            if (pageNum == pages && i == records.size() - 1) {
                bookingScheduleRuleVo.setStatus(1);
            }
            //放入集合中
            bookingScheduleRuleVoList.add(bookingScheduleRuleVo);
        }

        HashMap<String, Object> map = new HashMap<>();

        map.put("bookingScheduleRuleVoList", bookingScheduleRuleVoList);
        map.put("total", page.getTotal());

        Department department = departmentRepository.findByHoscodeAndDepcode(hoscode, depcode);

        HashMap<String, Object> baseMap = new HashMap<>();
        baseMap.put("releaseTime", bookingRule.getReleaseTime());
        baseMap.put("workDateString", new DateTime().toString("yyyy月MM日"));
        baseMap.put("depname", department.getDepname());
        baseMap.put("bigname", department.getBigname());
        baseMap.put("hosname", hospital.getHosname());

        map.put("baseMap", baseMap);
        return map;
    }

    @Override
    public Schedule getScheduleDetailById(String scheduleId) {
        Optional<Schedule> optional = scheduleRepository.findById(new ObjectId(scheduleId));
        if (optional.isPresent()) {
            Schedule schedule = optional.get();
            packSchedule(schedule);
            return schedule;
        }

        return null;
    }

    @Override
    public ScheduleOrderVo getScheduleOrderVo(String scheduleId) {
        Schedule schedule = getScheduleDetailById(scheduleId);

        //医院编号
        Hospital hospital = hospitalRepository.findByHoscode(schedule.getHoscode());
        //科室编号
        Department department = departmentRepository.findByHoscodeAndDepcode(schedule.getHoscode(), schedule.getDepcode());

        ScheduleOrderVo scheduleOrderVo = new ScheduleOrderVo();

        scheduleOrderVo.setHosname(hospital.getHosname());
        scheduleOrderVo.setDepname(department.getDepname());
        BeanUtils.copyProperties(hospital, scheduleOrderVo);
        BeanUtils.copyProperties(department, scheduleOrderVo);
        scheduleOrderVo.setReserveDate(schedule.getWorkDate());
        scheduleOrderVo.setReserveTime(schedule.getWorkTime());

        scheduleOrderVo.setHosScheduleId(schedule.getHosScheduleId());
        scheduleOrderVo.setTitle(schedule.getTitle());
        scheduleOrderVo.setAvailableNumber(schedule.getAvailableNumber());
        scheduleOrderVo.setAmount(schedule.getAmount());

        BookingRule bookingRule = hospital.getBookingRule();
        DateTime dateTime = new DateTime(schedule.getWorkDate()).plusDays(bookingRule.getQuitDay());
        DateTime quitTime = parseDateToDateTime(dateTime.toDate(), bookingRule.getQuitTime());
        scheduleOrderVo.setQuitTime(quitTime.toDate());


        return scheduleOrderVo;
    }

    private void packSchedule(Schedule schedule) {
        String hosname = hospitalRepository.findByHoscode(schedule.getHoscode()).getHosname();
        Department department = departmentRepository.findByHoscodeAndDepcode(schedule.getHoscode(), schedule.getDepcode());
        String depname = department.getDepname();
        String dayOfWeek = DateUtil.getDayOfWeek(new DateTime(schedule.getWorkDate()));
        String workTimeString = schedule.getWorkTime() == 0 ? "上午" : "下午";

        schedule.getParam().put("hosname", hosname);
        schedule.getParam().put("depname", depname);
        schedule.getParam().put("dayOfWeek", dayOfWeek);
        schedule.getParam().put("workTimeString", workTimeString);
        //id为ObjectId类型时需要进行转换
        schedule.getParam().put("id", schedule.getId().toString());
    }

    private com.baomidou.mybatisplus.extension.plugins.pagination.Page<Date> getDateList(Integer pageNum, Integer pageSize, BookingRule bookingRule) {
        Integer ruleCycle = bookingRule.getCycle();
        String releaseTime = bookingRule.getReleaseTime();

        DateTime dateTime = parseDateToDateTime(new Date(), releaseTime);

        //如果在当前时间段之间就说明已经开始预约了，可以加继续延后一天，最后一天可以放入倒计时
        if (dateTime.isBeforeNow()) {
            ruleCycle += 1;
        }

        List<Date> dateList = new ArrayList<>();
        //填充这一段时间的日期
        for (int i = 0; i < ruleCycle; i++) {
            //格式化
            String s = new DateTime().plusDays(i).toString("yyyy-MM-dd");
            dateList.add(new DateTime(s).toDate());
        }

        //分页设置
        int start = (pageNum - 1) * pageSize;
        int end = start + pageSize;
        //有可能最后一页有空余就会空指针，判断一下
        if (end > dateList.size()) {
            end = dateList.size();
        }

        List<Date> resultDateList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            resultDateList.add(dateList.get(i));
        }

        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Date> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(pageNum, pageSize, dateList.size());
        page.setRecords(resultDateList);
        return page;
    }

    private DateTime parseDateToDateTime(Date date, String releaseTime) {
        String s = new DateTime(date).toString("yyyy-MM-dd") + " " + releaseTime;
        return DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").parseDateTime(s);
    }
}

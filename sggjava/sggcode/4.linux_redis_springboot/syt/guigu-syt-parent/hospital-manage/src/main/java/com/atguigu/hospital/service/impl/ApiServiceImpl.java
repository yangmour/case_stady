package com.atguigu.hospital.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.hospital.mapper.HospitalSetMapper;
import com.atguigu.hospital.mapper.ScheduleMapper;
import com.atguigu.hospital.model.HospitalSet;
import com.atguigu.hospital.model.Schedule;
import com.atguigu.hospital.service.ApiService;
import com.atguigu.hospital.util.BeanUtils;
import com.atguigu.hospital.util.HttpRequestHelper;
import com.atguigu.hospital.util.YyghException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private HospitalSetMapper hospitalSetMapper;

    @Override
    public String getHoscode() {
        HospitalSet hospitalSet = hospitalSetMapper.selectById(1);
        return hospitalSet.getHoscode();
    }

    @Override
    public String getSignKey() {
        HospitalSet hospitalSet = hospitalSetMapper.selectById(1);
        return hospitalSet.getSignKey();
    }

    private String getApiUrl() {
        HospitalSet hospitalSet = hospitalSetMapper.selectById(1);
        return hospitalSet.getApiUrl();
    }

    @Override
    public JSONObject getHospital() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hoscode",this.getHoscode());
        paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
        paramMap.put("sign", HttpRequestHelper.getSign(paramMap, this.getSignKey()));
        JSONObject respone = HttpRequestHelper.sendRequest(paramMap,this.getApiUrl()+"/api/hosp/hospital/show");
        System.out.println(respone.toJSONString());
        if(null != respone && 200 == respone.getIntValue("code")) {
            JSONObject jsonObject = respone.getJSONObject("data");
            return jsonObject;
        }
        return null;
    }

    @Override
    public boolean saveHospital(String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hoscode",this.getHoscode());
        paramMap.put("hosname",jsonObject.getString("hosname"));
        paramMap.put("hostype",jsonObject.getString("hostype"));
        paramMap.put("provinceCode",jsonObject.getString("provinceCode"));
        paramMap.put("cityCode", jsonObject.getString("cityCode"));
        paramMap.put("districtCode",jsonObject.getString("districtCode"));
        paramMap.put("address",jsonObject.getString("address"));
        paramMap.put("intro",jsonObject.getString("intro"));
        paramMap.put("route",jsonObject.getString("route"));
        //图片
        paramMap.put("logoData", jsonObject.getString("logoData"));

        JSONObject bookingRule = jsonObject.getJSONObject("bookingRule");
        paramMap.put("bookingRule",bookingRule.toJSONString());

        paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
        paramMap.put("sign", HttpRequestHelper.getSign(paramMap, this.getSignKey()));

        JSONObject respone = HttpRequestHelper.sendRequest(paramMap,this.getApiUrl()+"/api/hosp/saveHospital");
        System.out.println(respone.toJSONString());

        if(null != respone && 200 == respone.getIntValue("code")) {
            return true;
        } else {
            throw new YyghException(respone.getString("message"), 201);
        }
    }

    @Override
    public Map<String, Object> findDepartment(int pageNum, int pageSize) {
        Map<String, Object> result = new HashMap();

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hoscode",this.getHoscode());
        //paramMap.put("depcode",depcode);
        paramMap.put("page",pageNum);
        paramMap.put("limit",pageSize);
        paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
        paramMap.put("sign", HttpRequestHelper.getSign(paramMap, this.getSignKey()));
        JSONObject respone = HttpRequestHelper.sendRequest(paramMap,this.getApiUrl()+"/api/hosp/department/list");
        if(null != respone && 200 == respone.getIntValue("code")) {
            JSONObject jsonObject = respone.getJSONObject("data");

            result.put("total", jsonObject.getLong("totalElements"));
            result.put("pageNum", pageNum);
            result.put("list", jsonObject.getJSONArray("content"));
        } else {
            throw new YyghException(respone.getString("message"), 201);
        }
        return result;
    }

    @Override
    public boolean saveDepartment(String data) {
        JSONArray jsonArray = new JSONArray();
        if(!data.startsWith("[")) {
            JSONObject jsonObject = JSONObject.parseObject(data);
            jsonArray.add(jsonObject);
        } else {
            jsonArray = JSONArray.parseArray(data);
        }

        for(int i=0, len=jsonArray.size(); i<len; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("hoscode",this.getHoscode());
            paramMap.put("depcode",jsonObject.getString("depcode"));
            paramMap.put("depname",jsonObject.getString("depname"));
            paramMap.put("intro",jsonObject.getString("intro"));
            paramMap.put("bigcode", jsonObject.getString("bigcode"));
            paramMap.put("bigname",jsonObject.getString("bigname"));

            paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
            paramMap.put("sign",HttpRequestHelper.getSign(paramMap, this.getSignKey()));
            JSONObject respone = HttpRequestHelper.sendRequest(paramMap,this.getApiUrl()+"/api/hosp/saveDepartment");
            System.out.println(respone.toJSONString());

            if(null == respone || 200 != respone.getIntValue("code")) {
                throw new YyghException(respone.getString("message"), 201);
            }
        }
        return true;
    }

    @Override
    public boolean removeDepartment(String depcode) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hoscode",this.getHoscode());
        paramMap.put("depcode",depcode);
        paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
        paramMap.put("sign", HttpRequestHelper.getSign(paramMap, this.getSignKey()));
        JSONObject respone = HttpRequestHelper.sendRequest(paramMap,this.getApiUrl()+"/api/hosp/department/remove");
        System.out.println(respone.toJSONString());
        if(null != respone && 200 == respone.getIntValue("code")) {
            return true;
        } else {
            throw new YyghException(respone.getString("message"), 201);
        }
    }

    @Override
    public Map<String, Object> findSchedule(int pageNum, int pageSize) {
        Map<String, Object> result = new HashMap();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hoscode",this.getHoscode());
        //paramMap.put("depcode",depcode);
        paramMap.put("page",pageNum);
        paramMap.put("limit",pageSize);
        paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
        paramMap.put("sign", HttpRequestHelper.getSign(paramMap, this.getSignKey()));
        JSONObject respone = HttpRequestHelper.sendRequest(paramMap,this.getApiUrl()+"/api/hosp/schedule/list");
        System.out.println(respone.toJSONString());
        if(null != respone && 200 == respone.getIntValue("code")) {
            JSONObject jsonObject = respone.getJSONObject("data");

            result.put("total", jsonObject.getLong("totalElements"));
            result.put("pageNum", pageNum);
            result.put("list", jsonObject.getJSONArray("content"));
        } else {
            throw new YyghException(respone.getString("message"), 201);
        }
        return result;
    }

    @Override
    public boolean saveSchedule(String data) {
        JSONArray jsonArray = new JSONArray();
        if(!data.startsWith("[")) {
            JSONObject jsonObject = JSONObject.parseObject(data);
            jsonArray.add(jsonObject);
        } else {
            jsonArray = JSONArray.parseArray(data);
        }

        for(int i=0, len=jsonArray.size(); i<len; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            Long id = jsonObject.getLong("hosScheduleId");
            Schedule schedule = new Schedule();
            schedule.setId(id);
            schedule.setHoscode(this.getHoscode());
            schedule.setDepcode(jsonObject.getString("depcode"));
            schedule.setTitle(jsonObject.getString("title"));
            schedule.setDocname(jsonObject.getString("docname"));
            schedule.setSkill(jsonObject.getString("skill"));
            schedule.setWorkDate(jsonObject.getString("workDate"));
            schedule.setWorkTime(jsonObject.getInteger("workTime"));
            schedule.setReservedNumber(jsonObject.getInteger("reservedNumber"));
            schedule.setAvailableNumber(jsonObject.getInteger("availableNumber"));
            schedule.setAmount(jsonObject.getString("amount"));
            schedule.setStatus(1);

            Schedule targetSchedule = scheduleMapper.selectById(id);
            if(null != targetSchedule) {
                //值copy不为null的值，该方法为自定义方法
                BeanUtils.copyBean(schedule, targetSchedule, Schedule.class);
                scheduleMapper.updateById(targetSchedule);
            } else {
                scheduleMapper.insert(schedule);
            }

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("hoscode",schedule.getHoscode());
            paramMap.put("depcode",schedule.getDepcode());
            paramMap.put("title",schedule.getTitle());
            paramMap.put("docname",schedule.getDocname());
            paramMap.put("skill", schedule.getSkill());
            paramMap.put("workDate",schedule.getWorkDate());
            paramMap.put("workTime", schedule.getWorkTime());
            paramMap.put("reservedNumber",schedule.getReservedNumber());
            paramMap.put("availableNumber",schedule.getAvailableNumber());
            paramMap.put("amount",schedule.getAmount());
            paramMap.put("status",schedule.getStatus());
            paramMap.put("hosScheduleId",schedule.getId());
            paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
            paramMap.put("sign",HttpRequestHelper.getSign(paramMap, this.getSignKey()));

            JSONObject respone = HttpRequestHelper.sendRequest(paramMap,this.getApiUrl()+"/api/hosp/saveSchedule");
            System.out.println(respone.toJSONString());
            if(null == respone || 200 != respone.getIntValue("code")) {
                throw new YyghException(respone.getString("message"), 201);
            }
        }
        return false;
    }

    @Override
    public boolean removeSchedule(String hosScheduleId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hoscode",this.getHoscode());
        paramMap.put("hosScheduleId",hosScheduleId);
        paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
        paramMap.put("sign", HttpRequestHelper.getSign(paramMap, this.getSignKey()));
        JSONObject respone = HttpRequestHelper.sendRequest(paramMap,this.getApiUrl()+"/api/hosp/schedule/remove");
        System.out.println(respone.toJSONString());
        if(null != respone && 200 == respone.getIntValue("code")) {
            //从医院端删除数据
            scheduleMapper.deleteById(Long.parseLong(hosScheduleId));

            return true;
        } else {
            throw new YyghException(respone.getString("message"), 201);
        }
    }
}

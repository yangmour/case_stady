package com.atguigu.syt.yun.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.common.service.prop.SmsProperties;
import com.atguigu.syt.yun.service.SmsService;
import com.atguigu.syt.yun.utils.HttpUtils;
import com.atguigu.common.service.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/18 -15:31
 * @Version: 1.0
 */
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private SmsProperties smsProperties;

    @Override

    public boolean sendCode(String phone) {

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + smsProperties.getAppcode());
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        String fourBitRandom = RandomUtil.getFourBitRandom();
        System.out.println(fourBitRandom);
        bodys.put("content", "code:" + fourBitRandom);
        redisTemplate.opsForValue().set("code:" + phone, fourBitRandom, 5, TimeUnit.MINUTES);
        bodys.put("phone_number", phone);
        bodys.put("template_id", "CST_ptdie100");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(smsProperties.getHost(),
                    smsProperties.getPath(),
                    smsProperties.getMethod(),
                    headers,
                    querys,
                    bodys);
            System.out.println(response.toString());
            String data = EntityUtils.toString(response.getEntity());
            HashMap<String, String> resultMap = JSONObject.parseObject(data, HashMap.class);
            String status = resultMap.get("status");
            if (!"OK".equals(status)) {
                String reason = resultMap.get("reason");
                log.error("短信发送失败：status = " + status + ", reason = " + reason);
                throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "短信发送失败");
            }
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
            return true;
        } catch (Exception e) {
            log.info("SmsServiceImpl.sendCode执行完毕,短信发送失败,结果:{}", ExceptionUtils.getStackTrace(e));
            return false;
        }
    }
}

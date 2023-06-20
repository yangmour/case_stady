package com.atguigu.syt.yun;

/*==================================
      时 间:   2023-06-17
      讲 师:   刘  辉
      描 述:   尚硅谷教学团队
===================================*/

import com.atguigu.common.service.prop.SmsProperties;
import com.atguigu.syt.yun.utils.HttpUtils;
import com.atguigu.common.service.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class SMSTest {
    @Autowired
    private SmsProperties smsProperties;

    @Test
    public void test2() {
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + smsProperties.getAppcode());
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        String fourBitRandom = RandomUtil.getFourBitRandom();
        System.out.println(fourBitRandom);
        bodys.put("content", "code:" + "测试");
        bodys.put("phone_number", "15133695630");
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
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            log.info("SmsServiceImpl.sendCode执行完毕,短信发送失败,结果:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    @Test
    public void test1() {
        String host = "https://dfsns.market.alicloudapi.com";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "26d5751ab60548ab8878e9516d798d2b";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        String fourBitRandom = RandomUtil.getFourBitRandom();
        System.out.println(fourBitRandom);
        bodys.put("content", "code:" + "测试");
        bodys.put("phone_number", "15133695630");
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
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

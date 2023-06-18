package com.atguigu.syt.yun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*-------------------------------------------------
      时 间:   2022-08-03
      讲 师:   刘  辉
      描 述:   尚硅谷教学团队
---------------------------------------------------*/
@SpringBootTest
public class AppTest {

    @Test
    public void test1(){
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAI5tGxRuvsKDTctRMZrA5Y", "EjAQTwhgVFg968p1j29pSRxv4tw7Gu");
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers("151*****630");//接收短信的手机号码

        request.setSignName("简效课堂");//短信签名名称
        request.setTemplateCode("SMS_205402620");//短信模板CODE
       // request.setTemplateParam("1234");//短信模板变量对应的实际值
        request.putQueryParameter("TemplateParam","{\"number\":\""+1234+"\"}");

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

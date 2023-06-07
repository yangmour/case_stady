package com.atguigu.syt.user.controller.front;

import com.atguigu.syt.user.utils.WxProperties;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/07 -20:16
 * @Version: 1.0
 */

@Api(tags = "微信扫码登录")
@Controller//注意这里没有配置 @RestController
@RequestMapping("/front/user/wx")
@Slf4j
public class FrontWxController {

    @Autowired
    private WxProperties wxProperties;

    @GetMapping("login")
    public String login() {
//        StringBuilder stringBuilderUrl = new StringBuilder()
//                .append("https://open.weixin.qq.com/connect/qrconnect")
//                .append("?appid=%s")
//                .append("&redirect_uri=%s")
//                .append("&response_type=code")
//                .append("&scope=snsapi_login")
//                .append("&state=%s")
//                .append("#wechat_redirect");

        StringBuffer stringBuilderUrl = new StringBuffer()
                .append("https://open.weixin.qq.com/connect/qrconnect")
                .append("?appid=%s")
                .append("&redirect_uri=%s")
                .append("&response_type=code")
                .append("&scope=snsapi_login")
                .append("&state=%s")
                .append("#wechat_redirect");

        long l = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        String state = Long.toHexString(l);
        String qrcodeUrl = String.format(
                stringBuilderUrl.toString(),
                wxProperties.getAppId(),
                wxProperties.getRedirectUri(),
                state);
        System.out.println(qrcodeUrl);
        return "redirect:" + qrcodeUrl;
    }
}

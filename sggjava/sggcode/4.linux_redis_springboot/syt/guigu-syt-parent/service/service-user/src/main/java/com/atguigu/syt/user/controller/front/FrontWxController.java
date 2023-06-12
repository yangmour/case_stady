package com.atguigu.syt.user.controller.front;

import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.user.utils.WxProperties;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
    public String login(HttpSession httpSession) {
//        StringBuilder stringBuilderUrl = new StringBuilder()
//                .append("https://open.weixin.qq.com/connect/qrconnect")
//                .append("?appid=%s")
//                .append("&redirect_uri=%s")
//                .append("&response_type=code")
//                .append("&scope=snsapi_login")
//                .append("&state=%s")
//                .append("#wechat_redirect");

        String qrcodeUrl = null;
        try {
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

            //将state设置到session中
            httpSession.setAttribute("wx_open_state", state);
            //设置编码格式
            String encodeUrl = URLEncoder.encode(wxProperties.getRedirectUri(), "utf-8");

            qrcodeUrl = String.format(
                    stringBuilderUrl.toString(),
                    wxProperties.getAppId(),
                    encodeUrl,
                    state);
        } catch (UnsupportedEncodingException e) {
            throw new GuiguException(ResultCodeEnum.URL_ENCODE_ERROR, e);
        }
        return "redirect:" + qrcodeUrl;
    }
}

package com.atguigu.syt.user.controller.api;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.service.utils.HttpUtil;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.enums.UserStatusEnum;
import com.atguigu.syt.model.user.UserInfo;
import com.atguigu.syt.user.service.UserInfoService;
import com.atguigu.syt.user.utils.CookieUtils;
import com.atguigu.syt.user.utils.WxProperties;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/12 -15:18
 * @Version: 1.0
 */
@Api(tags = "微信扫码登录回调")
@Controller//注意这里没有配置 @RestController
@RequestMapping("/api/user/wx")
@Slf4j
@RequiredArgsConstructor
public class ApiWxController {

    private final WxProperties WX_PROPERTIES;
    private final UserInfoService userInfoService;
    private final RedisTemplate redisTemplate;


    @GetMapping("callback")
    public String callback(String code, String state, HttpSession httpSession, HttpServletResponse httpServletResponse) {

        try {
            if (StringUtils.isEmpty(code) || StringUtils.isEmpty(state) || !state.equals(httpSession.getAttribute("wx_open_state"))) {
                throw new GuiguException(ResultCodeEnum.ILLEGAL_CALLBACK_REQUEST_ERROR);
            }

            log.info("ApiWxController.callback执行完毕,结果:{}", state);
            log.info("ApiWxController.callback执行完毕,结果:{}", code);

            //https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
            StringBuilder stringBuilderUrl = new StringBuilder();
            stringBuilderUrl.append("https://api.weixin.qq.com/sns/oauth2/access_token")
                    .append("?appid=%s")
                    .append("&secret=%s")
                    .append("&code=%s")
                    .append("&grant_type=authorization_code");

            String accessTokenUrl = String.format(stringBuilderUrl.toString(),
                    WX_PROPERTIES.getAppId(),
                    WX_PROPERTIES.getAppSecret(),
                    code);

            //发送请求获取数据
            byte[] respdata = HttpUtil.doGet(accessTokenUrl);

            String respStr = new String(respdata);
            JSONObject respJson = JSONObject.parseObject(respStr);

            //查看是否正确
            if (!StringUtils.isEmpty(respJson.getString("errcode"))) {
                throw new GuiguException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
            }

            //获取到token等信息
            String accessToken = respJson.getString("access_token");
            String openid = (String) respJson.get("openid");

            //根据openid查看有没有注册过
            UserInfo getUserInfo = userInfoService.getUserInfoByOpenId(openid);
            log.info("ApiWxController.callback执行完毕,结果:{}", getUserInfo);

            //有注册过
            if (getUserInfo != null) {
                if (getUserInfo.getStatus().intValue() == UserStatusEnum.LOCK.getStatus().intValue()) {
                    throw new GuiguException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
                }
            } else { //首次登陆
                //https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
                StringBuilder stringBuilderUserInfoUrl = new StringBuilder();
                stringBuilderUserInfoUrl.append("https://api.weixin.qq.com/sns/userinfo")
                        .append("?access_token=%s")
                        .append("&openid=%s");
                String userInfoUrl = String.format(stringBuilderUserInfoUrl.toString(), accessToken, openid);
                String userInfoResp = new String(HttpUtil.doGet(userInfoUrl));
                log.info("ApiWxController.callback执行完毕,结果:{}", userInfoResp);

                JSONObject userInfoRespJson = JSONObject.parseObject(userInfoResp);
                String nickname = userInfoRespJson.getString("nickname");
                String headimgurl = userInfoRespJson.getString("headimgurl");

                getUserInfo = new UserInfo();
                getUserInfo.setOpenid(openid);
                getUserInfo.setNickName(nickname);
                getUserInfo.setHeadImgUrl(headimgurl);
                log.info("ApiWxController.callback执行完毕,结果:{}", getUserInfo);

                //保存
                userInfoService.save(getUserInfo);
            }
            String name = getUserInfo.getName();
            if (StringUtils.isEmpty(name)) {
                name = getUserInfo.getNickName();
            }

            String token = UUID.randomUUID().toString().replaceAll("-", "");

            //登陆完成后返回一些用户信息
            //30分钟
            int cookieMaxTime = 30 * 60;
            CookieUtils.setCookie(httpServletResponse, "token", token, cookieMaxTime);
            CookieUtils.setCookie(httpServletResponse, "name", URLEncoder.encode(name), cookieMaxTime);
            CookieUtils.setCookie(httpServletResponse, "headimgurl", URLEncoder.encode(getUserInfo.getHeadImgUrl()), cookieMaxTime);

            //把token放入redis中
            redisTemplate.opsForValue().set("user:token:" + token, getUserInfo.getId(), 30, TimeUnit.MINUTES);
            //把用户信息保存到redis中，方便后续认证使用。
            //重定向：回到用户系统首页
            return "redirect:" + WX_PROPERTIES.getSytBaseUrl();
        } catch (GuiguException e) {
            log.info("ApiWxController.callback执行完毕,结果:{}", e.getMsg());
            return "redirect:" + WX_PROPERTIES.getSytBaseUrl() + "?code=201&" + URLEncoder.encode(e.getMsg());
        } catch (Exception e) {
            log.info("ApiWxController.callback执行完毕,结果:{}", e.getMessage());
            return "redirect:" + WX_PROPERTIES.getSytBaseUrl() + "?code=201&" + URLEncoder.encode("登陆失败！");
        }
    }

}

package com.atguigu.common.service.utils;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/12 -23:31
 * @Version: 1.0
 */

import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.vo.user.UserVo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 授权校验
 */
@Data
@Component
@RequiredArgsConstructor
public class AuthContextHolder {

    private final RedisTemplate redisTemplate;

    /**
     * 校验token是否存在并返回UserId
     */
    public Long checkAuth(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String token = httpServletRequest.getHeader("token");
        //不推荐使用这种
//        String token = CookieUtils.getCookie(httpServletRequest, "token");


        if (StringUtils.isEmpty(token)) {
//            throw new GuiguException(ResultCodeEnum.LOGIN_AUTH);
            return refresh(httpServletRequest, httpServletResponse);
        }
        UserVo userVo = (UserVo) redisTemplate.opsForValue().get("user:token:" + token);

        if (userVo == null) {
//            throw new GuiguException(ResultCodeEnum.LOGIN_AUTH);
            return refresh(httpServletRequest, httpServletResponse);
        }


//        long userId;
//        if (o instanceof Integer) {
//            userId = ((Integer) o).longValue();
//        } else if (o instanceof Long) {
//            userId = (Long) o;
//        } else {
//            userId = Long.parseLong((String) o);
//        }

        return userVo.getUserId();
    }

    /**
     * 刷新token
     *
     * @param request
     * @param response
     * @return
     */
    public Long refresh(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = CookieUtils.getCookie(request, "refreshToken");

        if (StringUtils.isEmpty(refreshToken)) {
            throw new GuiguException(ResultCodeEnum.LOGIN_TIMEOUT);//登录过期
        }

        UserVo userVo = (UserVo) redisTemplate.opsForValue().get("user:refreshToken:"+refreshToken);

        if (userVo == null) {
            throw new GuiguException(ResultCodeEnum.LOGIN_TIMEOUT);//登录过期
        }
        saveToken(userVo, response);
        return userVo.getUserId();
    }

    /**
     * 将token和refreshToken保存在redis和cookie中的通用方法
     *
     * @param userVo
     * @param httpServletResponse
     */
    public void saveToken(UserVo userVo, HttpServletResponse httpServletResponse) {
        String token = getToken();
        String refreshToken = getToken();


        //登陆完成后返回一些用户信息
        //30分钟
        int cookieMaxTime = 30 * 60;
        CookieUtils.setCookie(httpServletResponse, "token", token, cookieMaxTime);
        CookieUtils.setCookie(httpServletResponse, "refreshToken", refreshToken, cookieMaxTime * 2);
        CookieUtils.setCookie(httpServletResponse, "name", URLEncoder.encode(userVo.getName()), cookieMaxTime * 2);
        CookieUtils.setCookie(httpServletResponse, "headimgurl", URLEncoder.encode(userVo.getHeadimgurl()), cookieMaxTime * 2);

        //将生成token/refreshToken存入redis：token做键，userVo做值
        Integer timeOut = 30;
        redisTemplate.opsForValue().set("user:token:" + token, userVo, timeOut, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set("user:refreshToken:" + refreshToken, userVo, timeOut * 2, TimeUnit.MINUTES);


    }

    public String getToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}

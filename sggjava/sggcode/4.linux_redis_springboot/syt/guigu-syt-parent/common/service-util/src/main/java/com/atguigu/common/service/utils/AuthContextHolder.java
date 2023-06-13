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
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

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
    public Long checkAuth(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new GuiguException(ResultCodeEnum.LOGIN_AUTH);
        }
        Object o = redisTemplate.opsForValue().get("user:token:" + token);

        if (o == null) {
            throw new GuiguException(ResultCodeEnum.LOGIN_AUTH);
        }

        long userId;
        if (o instanceof Integer) {
            userId = ((Integer) o).longValue();
        } else if (o instanceof Long) {
            userId = (Long) o;
        } else {
            userId = Long.parseLong((String) o);
        }

        return userId;
    }

}

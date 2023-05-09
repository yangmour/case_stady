package com.xiwen.system.filter;

import com.xiwen.common.result.Result;
import com.xiwen.common.result.ResultCodeEnum;
import com.xiwen.common.util.ResponseUtil;
import com.xiwen.model.system.SysUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/09 -18:22
 * @Version: 1.0
 */

/**
 * <p>
 * 认证解析token过滤器
 * </p>
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private RedisTemplate redisTemplate;

    public TokenAuthenticationFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        // 登陆接口方向
        if ("/admin/system/index/login".equals(requestURI)) {
            doFilter(request, response, filterChain);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        // 如果不是空就放行
        if (authentication != null) {
            //都有的话就将认证放入到上下文中
            SecurityContextHolder.getContext().setAuthentication(authentication);
            doFilter(request, response, filterChain);
        } else { // 等于空就没有权限
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.PERMISSION));
        }

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        // 如果是其他接口就检查token
        String token = request.getHeader("token");

        // 如果不是空进入
        if (!StringUtils.isEmpty(token)) {
            SysUser sysUser = (SysUser) redisTemplate.boundValueOps(token).get();
            if (sysUser != null) {
                List<String> userPermsList = sysUser.getUserPermsList();
                // 看看有没有权限
                if (userPermsList != null && userPermsList.size() > 0) {

                    List<SimpleGrantedAuthority> simpleGrantedAuthorities = userPermsList.stream()
                            .filter(item -> !StringUtils.isEmpty(item))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
                    return new UsernamePasswordAuthenticationToken(request.getUserPrincipal(), sysUser.getPassword(), simpleGrantedAuthorities);
                } else { //没有权限可能只有初始查看的权限
                    return new UsernamePasswordAuthenticationToken(request.getUserPrincipal(), sysUser.getPassword(), Collections.emptyList());
                }
            }
        }
        return null;
    }
}

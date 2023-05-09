package com.xiwen.system.config;

import com.xiwen.system.filter.TokenAuthenticationFilter;
import com.xiwen.system.filter.TokenLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/09 -16:22
 * @Version: 1.0
 */

@Configuration
//开启注解功能，默认禁用注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity是开启SpringSecurity的默认行为
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启跨越以便前端调用接口
        http.cors()
                // 关闭csrf防止攻击
                .and().csrf().disable()
                //设置授权请求
                .authorizeRequests()
                //运行下面的路径访问
//                .antMatchers("/admin/system/index/login", "/admin/system/index/info", "/admin/system/index/logout").permitAll()
//                .antMatchers("/admin/system/index/login").permitAll()
                //设置其他路径全部需要认证
                .anyRequest().authenticated()
                // 设置认证过滤器
                .and().addFilter(new TokenLoginFilter(redisTemplate, authenticationManager()))
                // 添加一个token认证的过滤器,在进行登陆之前，如果是登陆界面直接方向，如果是其他页面进行token验证
                .addFilterBefore(new TokenAuthenticationFilter(redisTemplate), UsernamePasswordAuthenticationFilter.class);

        //禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/swagger-resources/**", "/webjars/**", "/v2/**", "/doc.html");
    }
}

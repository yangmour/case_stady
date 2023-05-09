package com.xiwen.system.config;

import com.xiwen.system.filter.TokenLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/09 -16:22
 * @Version: 1.0
 */

@Configuration
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
                .antMatchers("/admin/system/index/login", "/admin/system/index/info","/admin/system/index/logout").permitAll()
                //设置其他路径全部需要认证
                .anyRequest().authenticated()
                // 设置认证过滤器
                .and().addFilter(new TokenLoginFilter(redisTemplate));

        //禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico","/swagger-resources/**", "/webjars/**", "/v2/**", "/doc.html");
    }
}

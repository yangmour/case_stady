package com.xiwen.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -09:37
 * @Version: 1.0
 */
public class HelloFilter implements Filter {
    public HelloFilter() {
        System.out.println("创建HelloFilter过滤器");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化HelloFilter过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入helloFilter过滤器...");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁HelloFilter过滤器");
    }
}

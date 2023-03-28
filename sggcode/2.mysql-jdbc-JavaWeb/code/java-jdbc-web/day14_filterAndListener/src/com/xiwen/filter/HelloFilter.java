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
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入helloFilter过滤器...");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

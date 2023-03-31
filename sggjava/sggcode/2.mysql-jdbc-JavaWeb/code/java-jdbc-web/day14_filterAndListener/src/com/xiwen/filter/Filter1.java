package com.xiwen.filter; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -11:37
 * @Version: 1.0
 */

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("访问了Filter1前");

        chain.doFilter(request, response);
        System.out.println("访问了Filter1后");

    }
}
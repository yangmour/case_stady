package com.xiwen;

import javax.servlet.*;
import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/17 -09:40
 * @Version: 1.0
 */

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("创建了HelloServlet");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet的init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("访问了HelloServlet?");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet的destroy");

    }
}

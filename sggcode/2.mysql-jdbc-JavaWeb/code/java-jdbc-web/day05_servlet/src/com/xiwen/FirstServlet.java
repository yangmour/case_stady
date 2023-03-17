package com.xiwen;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/17 -11:01
 * @Version: 1.0
 */

/**
 * 两种方式可以
 * //@WebServlet(name = "FirstServlet", value = "/first")
 * //@WebServlet(value = "/first")
 */
//@WebServlet(name = "FirstServlet", value = "/first")
@WebServlet(value = "/first")
public class FirstServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("first的init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("访问了FirstServlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

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
        ServletContext servletContext = servletRequest.getServletContext();
        //获取共享域中的数据
        Object hello1 = servletContext.getAttribute("hello1");
        Object hello2 = servletContext.getAttribute("hello2");
        System.out.println(hello1);
        System.out.println(hello2);

        //获取上下文路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);

        //删除共享域中的数据
        servletContext.removeAttribute("hello1");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

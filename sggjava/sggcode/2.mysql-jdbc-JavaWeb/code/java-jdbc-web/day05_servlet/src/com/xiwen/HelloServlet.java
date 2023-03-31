package com.xiwen;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

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

        //获取xml中servlet中name名字
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        //获取servletContext对象
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);
        //获取当前servlet对象的参数
        String configKey1 = servletConfig.getInitParameter("configKey1");
        String configKey2 = servletConfig.getInitParameter("configKey1");
        System.out.println(configKey1 + "," + configKey2);
        //获取当前servlet对象参数的名字
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String nextElement = initParameterNames.nextElement();
            System.out.println(nextElement);
        }


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("访问了HelloServlet?");

        //用servletRequest对象获取全局初始化数据
        ServletContext servletContext = servletRequest.getServletContext();
        Object contextKey1 = servletContext.getInitParameter("contextKey1");
        Object contextKey2 = servletContext.getInitParameter("contextKey2");
        System.out.println(contextKey1 + "," + contextKey2);

        Enumeration<String> attributeNames = servletContext.getInitParameterNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println(attributeNames.nextElement());
        }

        String upload = servletContext.getRealPath("upload");
        System.out.println(upload);

        //设置全局共享参数让另一个servlet获取数据
        servletContext.setAttribute("hello1","HelloWorld1");
        servletContext.setAttribute("hello2","HelloWorld2");

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

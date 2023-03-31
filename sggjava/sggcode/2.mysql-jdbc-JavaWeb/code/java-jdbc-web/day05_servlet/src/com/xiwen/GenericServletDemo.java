package com.xiwen;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/17 -16:22
 * @Version: 1.0
 */
@WebServlet("/GenericServletDemo")
public class GenericServletDemo extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("调用了GenericServletDemo");
    }
}

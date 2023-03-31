package com.xiwen.base; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/22 -14:47
 * @Version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String methodParam = request.getParameter("method");

        try {
            Method method = this.getClass().getDeclaredMethod(methodParam, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, request, response);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

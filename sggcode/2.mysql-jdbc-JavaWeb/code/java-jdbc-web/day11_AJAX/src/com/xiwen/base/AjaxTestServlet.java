package com.xiwen.base;
/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/25 -15:22
 * @Version: 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxTest")
public class AjaxTestServlet extends BaseServlet {
    protected void first(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + ":" + password);

        int a = 10 / 0;
        PrintWriter writer = response.getWriter();
        writer.write("success");

    }


}

package com.xiwen.servlet; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -11:28
 * @Version: 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FilterPathServlet", value = "/user/123")
public class FilterPathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了FilterPathServlet");
    }
}

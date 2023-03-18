package com.xiwen.exercise; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -10:01
 * @Version: 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求了HelloServlet");
    }
}

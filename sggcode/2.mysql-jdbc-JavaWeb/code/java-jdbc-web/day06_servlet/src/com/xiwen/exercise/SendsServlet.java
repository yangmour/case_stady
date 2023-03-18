package com.xiwen.exercise; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -11:58
 * @Version: 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SeedsServlet", value = "/sends")
public class SendsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了SendsServlet");
        System.out.println("完成步骤二");
        Object key1 = request.getAttribute("key1");
        System.out.println(key1);
        //获取转发对象
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("successful.html");
        requestDispatcher.forward(request, response);



    }
}

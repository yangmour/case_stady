package com.xiwen.exercise; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -11:57
 * @Version: 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FirstServlet", value = "/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了FirstServlet");
        System.out.println("完成步骤一");

        //设置共享域数据
        request.setAttribute("key1","v");
        //获取转发对象
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("sends");
//        requestDispatcher.forward(request, response);

        //重定向相当于发送两次请求
//        response.sendRedirect("successful.html");
        response.sendRedirect("sends");
    }
}

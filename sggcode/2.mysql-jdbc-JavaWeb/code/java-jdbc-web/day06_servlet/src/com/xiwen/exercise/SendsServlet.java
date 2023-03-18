package com.xiwen.exercise; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -11:58
 * @Version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("successful.html");
//        requestDispatcher.forward(request, response);

//        response.setContentType("text/html;charset=utf-8");
//
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<h1>测试打印数据可以识别标签</h1>");
//        printWriter.print("测试打印数据可以写网页");


        //路径问题
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/successful.html");
//        requestDispatcher.forward(request, response);

        response.sendRedirect(request.getContextPath()+"/successful.html");
    }
}

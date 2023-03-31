package com.xiwen.base;
/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/25 -15:22
 * @Version: 1.0
 */

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
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


    protected void jsonTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取前端发送的异步请求的data数据
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        String s = stringBuilder.toString();
        //将json字符串放入javabean中
        Gson gson = new Gson();
        User user = gson.fromJson(s, User.class);
        System.out.println(user);

        //将接受的bean对象返回前端，list集合map集合同理
        String toJson = gson.toJson(user);
        PrintWriter writer = response.getWriter();
        writer.write(toJson);
    }


}

package com.xiwen; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -10:16
 * @Version: 1.0
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ThymeleafDemoServlet", value = "/thymeleafTest")
public class ThymeleafDemoServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mgs", "这是共享域的数据");
        request.setAttribute("http", "http://www.baidu.com");

        //设置全局参数
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("name", "tom");

        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("jdbc");
        list.add("mysql");
        request.setAttribute("list", list);

        request.setAttribute("date", new Date());

        processTemplate("ThymeleafViewTest", request, response);

    }
}

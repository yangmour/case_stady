package com.xiwen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/20 -16:57
 * @Version: 1.0
 */
@WebServlet("/thymeleafDemo")
public class ThymeleafDemo extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问了ThymeleafDemo");
        req.setAttribute("mgsError", "这是一条提示信息");
        processTemplate("target", req, resp);


    }
}

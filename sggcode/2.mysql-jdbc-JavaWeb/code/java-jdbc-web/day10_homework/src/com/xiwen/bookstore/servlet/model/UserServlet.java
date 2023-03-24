package com.xiwen.bookstore.servlet.model;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -10:15
 * @Version: 1.0
 */

import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.service.UserService;
import com.xiwen.bookstore.service.impl.UserServiceImpl;
import com.xiwen.bookstore.servlet.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private static UserService userService = new UserServiceImpl();


    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("user/login", request, response);
    }

    protected void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("user/regist", request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User selectUser = userService.login(user);
        if (selectUser != null) {
            processTemplate("user/login_success", request, response);
        } else {
            request.setAttribute("errMsg", "账号或密码错误！");
            processTemplate("user/login", request, response);
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean flag = userService.register(user);
        if (flag) {
            processTemplate("user/regist_success", request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/user/regist.html");
            requestDispatcher.forward(request, response);
        }
    }
}
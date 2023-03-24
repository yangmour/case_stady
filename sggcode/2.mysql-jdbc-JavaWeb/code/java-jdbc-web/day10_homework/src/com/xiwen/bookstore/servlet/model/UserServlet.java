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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private static UserService userService = new UserServiceImpl();


    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                request.setAttribute(cookie.getName(), cookie.getValue());
            } else if (cookie.getName().equals("password")) {
                request.setAttribute(cookie.getName(), cookie.getValue());
            }
//            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
        processTemplate("user/login", request, response);
    }

    protected void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("user/regist", request, response);
    }


    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/userServlet?method=toLogin");
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

        //设置cookie保存密码
        String cookiePath = request.getContextPath() + "/userServlet";
        Cookie username = new Cookie("username", user.getUsername());
        Cookie password = new Cookie("password", user.getPassword());
        username.setPath(cookiePath);
        password.setPath(cookiePath);
        //一周
        username.setMaxAge(60 * 60 * 24 * 7);
        password.setMaxAge(60 * 60 * 24 * 7);
        //将当前用户回显到输入框
        response.addCookie(username);
        response.addCookie(password);


        User selectUser = userService.login(user);
        if (selectUser != null) {
            //获取session
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("password", user.getUsername());
            //闲置30分钟自动失效
            session.setMaxInactiveInterval(30);

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
package com.xiwen.bookstore.servlet.model;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -10:15
 * @Version: 1.0
 */

import com.google.gson.Gson;
import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.service.UserService;
import com.xiwen.bookstore.service.impl.UserServiceImpl;
import com.xiwen.bookstore.servlet.base.BaseServlet;
import com.xiwen.bookstore.util.CommonResult;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private static UserService userService = new UserServiceImpl();


    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("username")) {
                    request.setAttribute(cookie.getName(), cookie.getValue());
                } else if (cookie.getName().equals("password")) {
                    request.setAttribute(cookie.getName(), cookie.getValue());
                } else if (cookie.getName().equals("check")) {
                    request.setAttribute(cookie.getName(), cookie.getValue());
                }
//            System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }

        processTemplate("user/login", request, response);
    }

    protected void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("user/regist", request, response);
    }


    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/userServlet?method=toLogin");
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


        String cookiePath = request.getContextPath() + "/userServlet";
        Cookie checkCookie = null;
        Cookie username = null;
        Cookie password = null;
        String check = request.getParameter("check");
        if (check != null) {
            checkCookie = new Cookie("check", "on");
            //设置cookie保存密码
            username = new Cookie("username", user.getUsername());
            password = new Cookie("password", user.getPassword());


            //一周
            username.setMaxAge(60 * 60 * 24 * 7);
            password.setMaxAge(60 * 60 * 24 * 7);
            checkCookie.setMaxAge(60 * 60 * 24 * 7);

        } else {
            username = new Cookie("username", "");
            password = new Cookie("password", "");
            checkCookie = new Cookie("check", "");
        }

        username.setPath(cookiePath);
        password.setPath(cookiePath);
        checkCookie.setPath(cookiePath);

        //将当前用户回显到输入框
        response.addCookie(username);
        response.addCookie(password);
        response.addCookie(checkCookie);


        User selectUser = userService.login(user);
        if (selectUser != null) {
            //获取session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
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

        String code = request.getParameter("code");
        Object codeKey = request.getSession().getAttribute("KAPTCHA_SESSION_KEY");

        if (codeKey.equals(code)) {
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
                processTemplate("user/regist", request, response);

            }
        } else {
            request.setAttribute("codeMsg", "验证码错误");
            processTemplate("user/regist", request, response);
        }


    }

    protected void checkUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        Gson gson = new Gson();
        User user = gson.fromJson(stringBuilder.toString(), User.class);

        boolean flag = userService.checkUserName(user);
        PrintWriter writer = response.getWriter();

        Map<String, String> map = new HashMap<>();

        CommonResult r = null;
        if (flag) {
            r = CommonResult.ok().setResultData(map);
        } else {
            map.put("checkMsg", "用户以重复！");
            r = CommonResult.error().setResultData(map);
        }
        String s = gson.toJson(r);
        writer.write(s);
        writer.close();

    }
}
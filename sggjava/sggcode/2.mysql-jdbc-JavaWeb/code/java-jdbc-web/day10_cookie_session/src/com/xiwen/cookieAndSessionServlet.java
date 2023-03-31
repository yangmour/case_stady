package com.xiwen; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -15:39
 * @Version: 1.0
 */

import com.xiwen.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookieAndSessionServlet")
public class cookieAndSessionServlet extends BaseServlet {

    protected void setCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置cookie
        Cookie username = new Cookie("username", "admin");
        Cookie password = new Cookie("password", "root");

        //设置保存存在时间秒为单位
        //60秒
        username.setMaxAge(60);
        //设置存在路径 //显示404但是发送的请求可以看到，其他路径看不到
        username.setPath(request.getContextPath() + "/user");

        response.addCookie(username);
        response.addCookie(password);

        response.getWriter().println("setCookie success");
    }

    protected void viewCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        for (Cookie cookie : cookies) {
            writer.println(cookie.getName() + "=>" + cookie.getValue());
        }
        writer.println("viewCookie success");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "=>" + cookie.getValue());
        }
        response.getWriter().println("getCookie success");
    }


    protected void setSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session会话
        HttpSession session = request.getSession();
        //判断是不是新的session
        boolean aNew = session.isNew();
        System.out.println(aNew);
        //获取id
        String sessionId = session.getId();
        System.out.println("sessionId = " + sessionId);
        //设置最大空闲会话时间，第二次获取session时如果在最大空闲时间内会使用当前session会话，超过了会创建新的
        session.setMaxInactiveInterval(60);
        session.setAttribute("id", sessionId);

        response.getWriter().println("setCookie success");
    }

    protected void viewSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session会话,第二次获取session时如果在最大空闲时间内会使用当前session会话，超过了会创建新的
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();

        boolean aNew = session.isNew();
        System.out.println(aNew);
        String sessionId = session.getId();
        System.out.println(sessionId);

        writer.println(aNew);
        writer.println("sessionId" + sessionId);

        writer.println("viewCookie success");
    }

    protected void getSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session会话,第二次获取session时如果在最大空闲时间内会使用当前session会话，超过了会创建新的
        HttpSession session = request.getSession();
        boolean aNew = session.isNew();
        System.out.println(aNew);
        String sessionId = session.getId();
        System.out.println(sessionId);

        response.getWriter().println("getCookie success");
    }

    protected void destroy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session
        HttpSession session = request.getSession();
        //销毁
        session.invalidate();

    }

}

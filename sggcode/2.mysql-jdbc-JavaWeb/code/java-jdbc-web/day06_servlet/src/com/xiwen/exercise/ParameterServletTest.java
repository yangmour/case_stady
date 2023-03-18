package com.xiwen.exercise; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -10:09
 * @Version: 1.0
 */

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class ParameterServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ParameterServletTest");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String[] hobby = request.getParameterValues("hobby");
        String email = request.getParameter("email");

        User user = new User(username, password, age, gender, hobby, email);
        System.out.println(user);

        //获取所有的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> System.out.println(k + ":" + Arrays.toString(v)));


        //获取路径信息和请求头信息http://localhost:63342/java-jdbc-web/day06_servlet/
        String scheme = request.getScheme();
        System.out.println(scheme);
        String serverName = request.getServerName();
        System.out.println(serverName);
        int serverPort = request.getServerPort();
        System.out.println("serverPort = " + serverPort);

        //获取请求头的来源和浏览器信息
        String referer = request.getHeader("Referer");
        System.out.println("referer = " + referer);
        String requestHeader = request.getHeader("User-Agent");
        System.out.println("User-Agent = " + requestHeader);
        //获取上下文路径就是项目访问路径名
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        System.out.println("测试BeanUtils");
        User user1 = new User();
        try {
            BeanUtils.populate(user1, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(user1);

    }
}

package com.xiwen.bookstore.servlet; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -22:58
 * @Version: 1.0
 */

import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.service.UserService;
import com.xiwen.bookstore.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            RequestDispatcher requestDispatcher = request.getRequestDispatcher( "pages/user/login_success.html");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/user/login.html");
            requestDispatcher.forward(request, response);
        }
    }
}
package com.xiwen.bookstore.servlet.model; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -15:49
 * @Version: 1.0
 */

import com.google.gson.Gson;
import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.service.OrderService;
import com.xiwen.bookstore.service.impl.OrderServiceImpl;
import com.xiwen.bookstore.servlet.base.BaseServlet;
import com.xiwen.bookstore.util.CommonResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/order")
public class CheckOutServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");

        // 业务
        CommonResult commonResult = orderService.checkOut(user, cart);

        //清空你的购物车
        session.removeAttribute("cart");
        PrintWriter writer = response.getWriter();
        writer.write(new Gson().toJson(commonResult));

        //渲染
//        response.sendRedirect(request.getContextPath() + "cart/checkout.html");
        processTemplate("cart/checkout", request, response);
    }

}

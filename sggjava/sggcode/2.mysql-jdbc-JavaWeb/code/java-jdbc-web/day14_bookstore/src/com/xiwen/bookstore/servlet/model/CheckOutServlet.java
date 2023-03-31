package com.xiwen.bookstore.servlet.model; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -15:49
 * @Version: 1.0
 */

import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.bean.Order;
import com.xiwen.bookstore.bean.OrderItem;
import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.service.OrderItemService;
import com.xiwen.bookstore.service.OrderService;
import com.xiwen.bookstore.service.impl.OrderItemServiceImpl;
import com.xiwen.bookstore.service.impl.OrderServiceImpl;
import com.xiwen.bookstore.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/order")
public class CheckOutServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();
    private OrderItemService orderItemService = new OrderItemServiceImpl();

    protected void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            processTemplate("index", request, response);
            return;
        }

        // 业务
        String uuid = orderService.checkOut(user, cart);

        //清空你的购物车
        session.removeAttribute("cart");

        request.setAttribute("uuid", uuid);
        //渲染
        processTemplate("cart/checkout", request, response);
    }

    protected void showOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        List<Order> orders = orderService.showOrders(user.getId());
        request.setAttribute("orders", orders);
        processTemplate("order/order", request, response);
    }

    //跳转没做
    protected void orderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItems = orderItemService.orderDetails(Integer.valueOf(orderId));
        request.setAttribute("orders", orderItems);
        //跳转到详情
//        processTemplate("", request, response);
    }
}

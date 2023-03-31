package com.xiwen.bookstore.service;

import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.bean.Order;
import com.xiwen.bookstore.bean.User;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -15:57
 * @Version: 1.0
 */
public interface OrderService {
    String checkOut(User user, Cart cart);

    List<Order> showOrders(Integer id);
}

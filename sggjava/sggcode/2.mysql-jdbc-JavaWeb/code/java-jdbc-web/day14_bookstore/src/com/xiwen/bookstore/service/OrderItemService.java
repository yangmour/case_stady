package com.xiwen.bookstore.service;

import com.xiwen.bookstore.bean.OrderItem;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/29 -10:52
 * @Version: 1.0
 */
public interface OrderItemService {
    List<OrderItem> orderDetails(Integer orderId);
}

package com.xiwen.bookstore.dao;

import com.xiwen.bookstore.bean.OrderItem;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -16:59
 * @Version: 1.0
 */
public interface OrderItemDao {
    boolean insert(OrderItem orderItem);

    List<OrderItem> getByOrderId(Integer orderId);
}

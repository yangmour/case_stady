package com.xiwen.bookstore.dao;

import com.xiwen.bookstore.bean.Order;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -16:40
 * @Version: 1.0
 */
public interface OrderDao {
    void insert(Order order);

    List<Order> getByUserId(Integer id);
}

package com.xiwen.bookstore.service.impl;

import com.xiwen.bookstore.bean.OrderItem;
import com.xiwen.bookstore.dao.OrderItemDao;
import com.xiwen.bookstore.dao.impl.OrderItemDaoImpl;
import com.xiwen.bookstore.service.OrderItemService;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/29 -10:52
 * @Version: 1.0
 */
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public List<OrderItem> orderDetails(Integer orderId) {
        return orderItemDao.getByOrderId(orderId);
    }
}

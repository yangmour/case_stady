package com.xiwen.bookstore.service;

import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.util.CommonResult;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -15:57
 * @Version: 1.0
 */
public interface OrderService {
    CommonResult checkOut(User user, Cart cart);
}

package com.xiwen.bookstore.dao;

import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.bean.User;

import java.sql.SQLException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -16:40
 * @Version: 1.0
 */
public interface OrderDao {
    Integer insert(User user, Cart cart) throws SQLException;
}

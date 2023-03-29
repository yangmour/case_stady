package com.xiwen.bookstore.dao.impl;

import com.xiwen.bookstore.bean.Book;
import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.bean.CartItem;
import com.xiwen.bookstore.bean.OrderItem;
import com.xiwen.bookstore.dao.BaseDao;
import com.xiwen.bookstore.dao.OrderItemDao;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -17:00
 * @Version: 1.0
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public boolean insert(Integer orderId, Cart cart) {
        String sql = "insert into t_order_item values(null,?,?,?,?,?,?)";
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            Book book = cartItem.getBook();
            update(sql, book.getBookName(), book.getPrice(), book.getImgPath(), cartItem.getCount(), cartItem.getAmount(), orderId);
        }
        return true;
    }
}

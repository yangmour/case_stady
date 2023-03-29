package com.xiwen.bookstore.service.impl;

import com.xiwen.bookstore.bean.Book;
import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.bean.CartItem;
import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.dao.BookDao;
import com.xiwen.bookstore.dao.OrderDao;
import com.xiwen.bookstore.dao.OrderItemDao;
import com.xiwen.bookstore.dao.impl.BookDaoImpl;
import com.xiwen.bookstore.dao.impl.OrderDaoImpl;
import com.xiwen.bookstore.dao.impl.OrderItemDaoImpl;
import com.xiwen.bookstore.service.OrderService;
import com.xiwen.bookstore.util.CommonResult;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -15:58
 * @Version: 1.0
 */
public class OrderServiceImpl implements OrderService {

    private BookDao bookDao = new BookDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public CommonResult checkOut(User user, Cart cart) {
        //先查看库存
        List<CartItem> cartItems = cart.getCartItems();
        List<Integer> ids = cartItems.stream().map(cartItem -> cartItem.getBook().getBookId()).collect(Collectors.toList());
        List<Book> books = bookDao.getByIds(ids);

        if (books.size() <= 0) {
            System.out.println("没有书");
            return CommonResult.error().setResultData(new HashMap<>().put("errorMsg", "库存没有书"));
        }
        //查看书的库存够不够
        for (Book book : books) {
            if (book.getStock() <= 0) {
                System.out.println("书的库存不足！");
                return CommonResult.error().setResultData(new HashMap<>().put("errorMsg", "书的库存不足"));
            }
            for (CartItem cartItem : cartItems) {
                Book itemBook = cartItem.getBook();
                //当库存小于购买的时候就报错
                if (itemBook.getBookId().equals(book.getBookId()) && book.getStock() < itemBook.getStock()) {
                    System.out.println("书的库存不足！");
                    return CommonResult.error().setResultData(new HashMap<>().put("errorMsg", "书的库存不足"));
                }
            }


        }


        //开启事务
//        Connection connection = JDBCTools.getConnection();
        try {
//            connection.setAutoCommit(false);

            //书的库存够了就生成订单
            Integer orderId = orderDao.insert(user, cart);
            //添加书的数据项
            orderItemDao.insert(orderId, cart);
            //库存减去购买的数量
            for (CartItem cartItem : cartItems) {
                Book itemBook = cartItem.getBook();
                Book book = bookDao.getById(String.valueOf(itemBook.getBookId()));
                book.setStock(book.getStock() - cartItem.getCount());
                book.setSales(book.getSales() + cartItem.getCount());
                bookDao.updateBook(book);
            }
            return CommonResult.ok();
        } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
            e.printStackTrace();
            return CommonResult.error();
        } finally {
//            try {
//                connection.commit();
//                connection.setAutoCommit(true);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
    }
}

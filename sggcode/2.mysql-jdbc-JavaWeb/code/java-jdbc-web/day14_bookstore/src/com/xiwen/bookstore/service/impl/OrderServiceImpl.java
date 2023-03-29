package com.xiwen.bookstore.service.impl;

import com.xiwen.bookstore.bean.*;
import com.xiwen.bookstore.dao.BookDao;
import com.xiwen.bookstore.dao.OrderDao;
import com.xiwen.bookstore.dao.OrderItemDao;
import com.xiwen.bookstore.dao.impl.BookDaoImpl;
import com.xiwen.bookstore.dao.impl.OrderDaoImpl;
import com.xiwen.bookstore.dao.impl.OrderItemDaoImpl;
import com.xiwen.bookstore.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
    public String checkOut(User user, Cart cart) {
            //先查看库存
            List<CartItem> cartItems = cart.getCartItems();
            List<Integer> ids = cartItems.stream().map(cartItem -> cartItem.getBook().getBookId()).collect(Collectors.toList());
            List<Book> books = bookDao.getByIds(ids);

            if (books.size() <= 0) {
                System.out.println("没有书");
                throw new RuntimeException("没有书");
            }
            //查看书的库存够不够
            for (Book book : books) {
                if (book.getStock() <= 0) {
                    System.out.println("书的库存不足！");
                    throw new RuntimeException("书的库存不足");

                }
                for (CartItem cartItem : cartItems) {
                    Book itemBook = cartItem.getBook();
                    //当库存小于购买的时候就报错
                    if (itemBook.getBookId().equals(book.getBookId()) && book.getStock() < itemBook.getStock()) {
                        System.out.println("书的库存不足！");
                        throw new RuntimeException("书的库存不足");
                    }
                }
            }


            //书的库存够了就生成订单
            String uuid = UUID.randomUUID().toString();
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Order order = new Order(
                    null,
                    uuid,
                    simpleDateFormat.format(date),
                    cart.getTotalCount(),
                    cart.getTotalAmount(),
                    0,
                    user.getId());

            orderDao.insert(order);
            //模拟报错测试回滚
//            int a = 10 / 0;
            for (CartItem cartItem : cartItems) {
                //添加书的数据项
                OrderItem orderItem = new OrderItem(
                        null,
                        cartItem.getBook().getBookName(),
                        cartItem.getBook().getPrice(),
                        cartItem.getBook().getImgPath(),
                        cartItem.getCount(),
                        cartItem.getAmount(),
                        order.getOrderId());
                //生成订单项
                orderItemDao.insert(orderItem);
                //修改图书库存
                Book book = cartItem.getBook();
                book.setStock(book.getStock() - cartItem.getCount());
                book.setSales(book.getSales() + cartItem.getCount());
                bookDao.updateBook(book);
            }
            return uuid;
    }

    @Override
    public List<Order> showOrders(Integer id) {
        return orderDao.getByUserId(id);
    }


}

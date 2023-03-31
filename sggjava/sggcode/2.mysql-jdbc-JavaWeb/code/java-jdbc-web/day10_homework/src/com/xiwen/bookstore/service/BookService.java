package com.xiwen.bookstore.service;

import com.xiwen.bookstore.bean.Book;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -11:55
 * @Version: 1.0
 */
public interface BookService {
    List<Book> selectAll();

    boolean addBook(Book book);

    boolean deleteById(String id);

    Book getById(String id);

    boolean updateBook(Book book);
}

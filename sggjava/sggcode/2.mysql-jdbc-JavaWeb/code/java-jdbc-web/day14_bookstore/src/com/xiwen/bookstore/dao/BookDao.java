package com.xiwen.bookstore.dao;

import com.xiwen.bookstore.bean.Book;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -11:43
 * @Version: 1.0
 */
public interface BookDao {
    List<Book> selectAll();

    boolean addBook(Book book);

    boolean deleteById(String id);

    Book getById(String id);

    boolean updateBook(Book book);

    List<Book> getByIds(List<Integer> ids);
}

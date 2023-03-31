package com.xiwen.bookstore.service.impl;

import com.xiwen.bookstore.bean.Book;
import com.xiwen.bookstore.dao.BookDao;
import com.xiwen.bookstore.dao.impl.BookDaoImpl;
import com.xiwen.bookstore.service.BookService;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -11:55
 * @Version: 1.0
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean deleteById(String id) {
        return bookDao.deleteById(id);
    }

    @Override
    public Book getById(String id) {
        return bookDao.getById(id);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }
}

package com.xiwen.bookstore.dao.impl;

import com.xiwen.bookstore.bean.Book;
import com.xiwen.bookstore.dao.BaseDao;
import com.xiwen.bookstore.dao.BookDao;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -11:46
 * @Version: 1.0
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> selectAll() {
        String sql = "select id bookId,title bookName,author,price,sales,stock,img_path imgPath from books";
        return getList(sql);
    }

    @Override
    public boolean addBook(Book book) {
        String sql = "insert into books values(null,?,?,?,?,?,?)";
        return update(sql, book.getBookName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getBookId());
    }

    @Override
    public boolean deleteById(String id) {
        String sql = "delete from books where id=?";
        return update(sql, id);
    }

    @Override
    public Book getById(String id) {
        String sql = "select id bookId,title bookName,author,price,sales,stock,img_path imgPath from books where id=?";
        return getBean(sql, id);
    }

    @Override
    public boolean updateBook(Book book) {
        String sql = "update books set title=?,author=?,price=?,sales=?,stock=? where id=?";
        return update(sql, book.getBookName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getBookId());
    }
}

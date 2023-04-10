package com.xiwen.service.impl;

import com.xiwen.dao.AccountDao;
import com.xiwen.dao.BookDao;
import com.xiwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/10 -16:52
 * @Version: 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public void purchase(int userId, String bookId) {

        Double price = bookDao.getById(bookId);
        bookDao.updateBookStock(bookId);
//        int a = 10 / 0;
        accountDao.updateBalance(userId, price);


    }

}

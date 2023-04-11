package com.xiwen.service.impl;

import com.xiwen.dao.AccountDao;
import com.xiwen.dao.BookDao;
import com.xiwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    /**
     * @param userId
     * @param bookId
     * @Transactional(propagation = Propagation.REQUIRED) 默认传播行为，要么都成功要么都回退
     * @Transactional(propagation = Propagation.REQUIRES_NEW) 默认传播行为，相当于每个小的事务，成一个提交一个，失败了就回滚当前方法事务与其他事务无关
     *
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void purchase(int userId, String bookId) {

        Double price = bookDao.getById(bookId);
        bookDao.updateBookStock(bookId);
//        int a = 10 / 0;
        accountDao.updateBalance(userId, price);
    }

}

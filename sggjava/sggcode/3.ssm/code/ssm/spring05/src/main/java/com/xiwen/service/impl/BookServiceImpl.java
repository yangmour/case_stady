package com.xiwen.service.impl;

import com.xiwen.dao.AccountDao;
import com.xiwen.dao.BookDao;
import com.xiwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     */
//    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED,
//            timeout = 3, //超时就回滚
////            readOnly = true,  //默认是false,如果是true就是只读
//            rollbackFor = {FileNotFoundException.class} //设置回滚的受检异常，一般不设置的话不会回滚
////            noRollbackFor = {ArithmeticException.class} //设置不回滚的异常
//    )
    public void purchase(int userId, String bookId) {

        Double price = bookDao.getById(bookId);
        bookDao.updateBookStock(bookId);
//        int a = 10 / 0;
//        new FileInputStream("");

        accountDao.updateBalance(userId, price);
    }

    /**
     * 测试事务的
     * 脏读 isolation = Isolation.READ_UNCOMMITTED
     * 不可重复读  isolation = Isolation.READ_COMMITTED
     * 幻读 isolation = Isolation.REPEATABLE_READ 锁行 解决了脏读，如果是mysql也解决了幻读，其他数据库没有解决幻读
     * 串行化 isolation = SERIALIZABLE 锁表
     */
//    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void purchase02(int userId, String bookId) {

        Double price = bookDao.getById(bookId);
        System.out.println("第一次" + price);
        price = bookDao.getById(bookId);
        System.out.println("第二次" + price);

    }

}

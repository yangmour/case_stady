package com.xiwen.service.impl;

import com.xiwen.service.BookService;
import com.xiwen.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/11 -10:06
 * @Version: 1.0
 */
@Component
public class CashierImpl implements Cashier {

    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    public void checkout(int userId, List<String> ids) {
        for (String id : ids) {
            bookService.purchase(userId, id);
            System.out.println(id + "成功！");
        }

    }
}

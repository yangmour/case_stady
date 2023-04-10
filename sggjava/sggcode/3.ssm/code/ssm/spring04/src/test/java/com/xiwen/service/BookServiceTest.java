package com.xiwen.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/10 -18:05
 * @Version: 1.0
 */
@ContextConfiguration("classpath:jdbc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void purchase() {
        bookService.purchase(1, String.valueOf(1001));
    }
}
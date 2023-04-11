package com.xiwen.service;

//import org.junit.Test;
//import org.junit.runner.RunWith;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/10 -18:05
 * @Version: 1.0
 */
//@ContextConfiguration("classpath:jdbc.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = "classpath:jdbc.xml")
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void purchase() {
        bookService.purchase(1, String.valueOf(1001));
    }

    @Test
    public void purchase02() {
        bookService.purchase02(1, String.valueOf(1001));
    }
}
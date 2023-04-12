package com.xiwen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/12 -15:18
 * @Version: 1.0
 */
@Controller
public class BookController {
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET)
    public String getBook(@PathVariable String bookId) {
        System.out.println("查询图书为" + bookId);
        return "success";
    }
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String insertBook() {
        System.out.println("新增图书");
        return "success";
    }
    @RequestMapping(value = "/book",method = RequestMethod.PUT)
    public String updateBook() {
        System.out.println("修改图书");
        return "success";
    }

    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable String bookId) {
        System.out.println("删除图书为" + bookId);
        return "success";
    }
}

package com.xiwen.bookstore.servlet.model;

import com.xiwen.bookstore.bean.Book;
import com.xiwen.bookstore.service.impl.BookServiceImpl;
import com.xiwen.bookstore.servlet.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -10:27
 * @Version: 1.0
 */
@WebServlet("/index.html")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = new BookServiceImpl().selectAll();
        req.setAttribute("books", books);
        processTemplate("index", req, resp);
    }
}
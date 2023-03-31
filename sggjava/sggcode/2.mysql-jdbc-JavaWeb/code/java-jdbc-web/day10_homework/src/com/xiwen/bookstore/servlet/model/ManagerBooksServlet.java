package com.xiwen.bookstore.servlet.model; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/24 -10:59
 * @Version: 1.0
 */

import com.xiwen.bookstore.bean.Book;
import com.xiwen.bookstore.service.BookService;
import com.xiwen.bookstore.service.impl.BookServiceImpl;
import com.xiwen.bookstore.servlet.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/managerBooksServlet")
public class ManagerBooksServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void managerBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.selectAll();
        request.setAttribute("books", books);
        processTemplate("manager/book_manager", request, response);
    }

    protected void toAddBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("manager/book_add", request, response);
    }

    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath() + "/managerBooksServlet?method=managerBooks");
    }

    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookService.deleteById(request.getParameter("id"));
        response.sendRedirect(request.getContextPath() + "/managerBooksServlet?method=managerBooks");
    }

    protected void toEditBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = bookService.getById(request.getParameter("id"));
        String id = request.getParameter("id");
        request.setAttribute("book", book);
        processTemplate("manager/book_edit", request, response);
    }

    protected void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(book, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath() + "/managerBooksServlet?method=managerBooks");
    }
}

package com.xiwen.bookstore.servlet.model; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/27 -11:39
 * @Version: 1.0
 */

import com.google.gson.Gson;
import com.xiwen.bookstore.bean.Book;
import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.service.impl.BookServiceImpl;
import com.xiwen.bookstore.servlet.base.BaseServlet;
import com.xiwen.bookstore.util.CommonResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends BaseServlet {

    protected void toCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("cart/cart", request, response);
    }


    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        PrintWriter writer = response.getWriter();
        try {
            //如果session中没有cart对象就创建一个，有就直接使用
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }

            //添加书
            String bookId = request.getParameter("bookId");
            Book book = new BookServiceImpl().getById(bookId);
            cart.addBook(book);

            //给返回值
            HashMap<String, Integer> map = new HashMap<>();
            map.put("totalCount", cart.getTotalCount());
            writer.write(new Gson().toJson(CommonResult.ok().setResultData(map)));
        } catch (Exception e) {
            e.printStackTrace();
            writer.write(new Gson().toJson(CommonResult.error()));
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

}

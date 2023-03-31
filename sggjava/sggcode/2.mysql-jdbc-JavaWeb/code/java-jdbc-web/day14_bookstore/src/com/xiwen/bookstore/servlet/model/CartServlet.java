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

    protected void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        PrintWriter writer = response.getWriter();

        HashMap<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        CommonResult commonResult = null;
        if (cart != null) {
            String s = getCartData(cart);
            writer.write(s);
        } else {
            commonResult = CommonResult.error();
            writer.write(gson.toJson(commonResult));
        }
        writer.close();
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();

        String bookId = request.getParameter("bookId");

        Cart cart = (Cart) session.getAttribute("cart");
        cart.deleteItem(Integer.parseInt(bookId));

        PrintWriter writer = response.getWriter();

        String s = getCartData(cart);

        writer.write(s);
        writer.close();
    }


    protected void clearItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        response.getWriter().write(new Gson().toJson(CommonResult.ok()));
    }

    public String getCartData(Cart cart) {
        Gson gson = new Gson();
        HashMap<String, Object> map = new HashMap<>();
        map.put("cartItems", cart.getCartItems());
        map.put("totalCount", cart.getTotalCount());
        map.put("totalAmount", cart.getTotalAmount());
        return gson.toJson(CommonResult.ok().setResultData(map));

    }

    protected void addCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        String bookId = request.getParameter("bookId");
        String sub = request.getParameter("sub");
        if ("sub".equals(sub)) { //减一
            cart.addCount(Integer.parseInt(bookId), -1);
        } else { //加一
            cart.addCount(Integer.parseInt(bookId), 1);
        }


        PrintWriter writer = response.getWriter();
        String s = getCartData(cart);

        writer.write(s);
        writer.close();
    }

    protected void modifCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        String bookId = request.getParameter("bookId");
        String count = request.getParameter("count");
        cart.modifCount(Integer.parseInt(bookId), Integer.parseInt(count));


        PrintWriter writer = response.getWriter();
        String s = getCartData(cart);

        writer.write(s);
        writer.close();
    }
}

package com.xiwen.bookstore.bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/27 -11:40
 * @Version: 1.0
 */
public class Cart {
    private Map<Integer, CartItem> cartItemMap = new HashMap<>();
    private Double totalAmount;


    public void addBook(Book book) {
        //如果没有就直接添加，有就数量加1
        CartItem cartItem = cartItemMap.get(book.getBookId());
        if (cartItem == null) {
            cartItem = new CartItem(book, 1);
            cartItemMap.put(book.getBookId(), cartItem);
        } else {
            cartItem.setCount(cartItemMap.get(book.getBookId()).getCount() + 1);
        }

        for (Map.Entry<Integer, CartItem> entry : cartItemMap.entrySet()) {
            System.out.println(entry);
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem cartItem : cartItemMap.values()) {
            totalCount += cartItem.getCount();
        }
        return totalCount;
    }

    public Double getTotalAmount() {

        BigDecimal totalAmount = new BigDecimal(0 + "");
        for (CartItem cartItem : cartItemMap.values()) {
            BigDecimal bigDecimalPrice = new BigDecimal(cartItem.getAmount() + "");
            totalAmount = totalAmount.add(bigDecimalPrice);
        }
        return totalAmount.doubleValue();
    }

    public List<CartItem> getCartItems() {
        return cartItemMap.values().stream().collect(Collectors.toList());
    }

    public void deleteItem(int bookId) {
        cartItemMap.remove(bookId);
    }

    public void addCount(int bookId, int num) {
        CartItem cartItem = cartItemMap.get(bookId);
        if (num == -1 && cartItem.getCount() == 1) {
            cartItemMap.remove(bookId);
        } else {
            cartItem.setCount(cartItem.getCount() + num);
        }
    }

    public void modifCount(int bookId, int count) {
        CartItem cartItem = cartItemMap.get(bookId);
        cartItem.setCount(count);
    }
}

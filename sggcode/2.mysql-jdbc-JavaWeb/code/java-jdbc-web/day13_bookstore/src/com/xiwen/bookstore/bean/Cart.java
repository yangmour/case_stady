package com.xiwen.bookstore.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/27 -11:40
 * @Version: 1.0
 */
public class Cart {
    private Map<Integer, CartItem> cartItemMap = new HashMap<>();
    private Integer count;
    private Double amount;


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
}

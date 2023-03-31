package com.xiwen.bookstore.bean;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/27 -11:42
 * @Version: 1.0
 */
public class CartItem {
    private Book book;
    private Integer count;
    private Double amount;

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;

        if (book != null) {
            BigDecimal bigDecimalCount = new BigDecimal(count + "");
            BigDecimal bigDecimalPrice = new BigDecimal(book.getPrice() + "");
            amount = bigDecimalCount.multiply(bigDecimalPrice).doubleValue();
        }
    }

    public CartItem() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        if (book != null) {
            BigDecimal bigDecimalCount = new BigDecimal(count + "");
            BigDecimal bigDecimalPrice = new BigDecimal(book.getPrice() + "");
            amount = bigDecimalCount.multiply(bigDecimalPrice).doubleValue();
        }
    }

    public Double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }
}

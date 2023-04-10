package com.xiwen.dao;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/10 -16:50
 * @Version: 1.0
 */
public interface BookDao {
    Double getById(String bookId);

    void updateBookStock(String bookId);
}

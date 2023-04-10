package com.xiwen.dao.impl;

import com.xiwen.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/10 -16:50
 * @Version: 1.0
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Double getById(String bookId) {
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, bookId);
    }

    @Override
    public void updateBookStock(String bookId) {
        String sql = "update book set stock = stock - ? where isbn = ?";
        jdbcTemplate.update(sql, 1, bookId);
    }
}

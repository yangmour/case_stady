package com.xiwen.dao.impl;

import com.xiwen.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/10 -16:51
 * @Version: 1.0
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateBalance(int userId, Double price) {
        String sql = "update account set balance = balance - ?  where id = ?";
        jdbcTemplate.update(sql, price, userId);
    }
}

package com.xiwen.bookstore.dao.impl;

import com.xiwen.bookstore.bean.Cart;
import com.xiwen.bookstore.bean.Order;
import com.xiwen.bookstore.bean.User;
import com.xiwen.bookstore.dao.BaseDao;
import com.xiwen.bookstore.dao.OrderDao;
import com.xiwen.bookstore.util.JDBCTools;

import java.sql.*;
import java.util.Date;
import java.util.UUID;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -16:40
 * @Version: 1.0
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

    @Override
    public Integer insert(User user, Cart cart) throws SQLException {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into t_order values (null,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        //uuid的低64位
        UUID uuid = UUID.randomUUID();
        preparedStatement.setObject(1, uuid.getLeastSignificantBits()); //id
        preparedStatement.setObject(2, new Date()); //create_time
        preparedStatement.setObject(3, cart.getTotalCount()); //count
        preparedStatement.setObject(4, cart.getTotalAmount()); //amount
        preparedStatement.setObject(5, 0); //status
        preparedStatement.setObject(6, user.getId()); //user_id
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        Integer order_Id = null;
        while (resultSet.next()) {
            order_Id = resultSet.getInt(1);
        }
        return order_Id;
    }
}

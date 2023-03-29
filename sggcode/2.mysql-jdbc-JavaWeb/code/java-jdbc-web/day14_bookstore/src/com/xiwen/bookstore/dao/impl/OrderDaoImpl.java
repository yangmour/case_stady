package com.xiwen.bookstore.dao.impl;

import com.xiwen.bookstore.bean.Order;
import com.xiwen.bookstore.bean.OrderItem;
import com.xiwen.bookstore.dao.BaseDao;
import com.xiwen.bookstore.dao.OrderDao;
import com.xiwen.bookstore.util.JDBCTools;

import java.sql.*;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -16:40
 * @Version: 1.0
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

    @Override
    public void insert(Order order) throws SQLException {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into t_order values (null,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        //uuid的低64位
        preparedStatement.setObject(1, order.getOrderSequence()); //id
        preparedStatement.setObject(2, order.getCreateTime()); //create_time
        preparedStatement.setObject(3, order.getTotalCount()); //count
        preparedStatement.setObject(4, order.getTotalAmount()); //amount
        preparedStatement.setObject(5, order.getOrderStatus()); //status
        preparedStatement.setObject(6, order.getUserId()); //user_id
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        while (resultSet.next()) {
            order.setOrderId(resultSet.getInt(1));
        }
    }

    @Override
    public List<Order> getByUserId(Integer id) {
        String sql = "select order_id orderId,order_sequence orderSequence,create_time createTime,total_count totalCount,total_amount totalAmount,order_status orderStatus,user_id userId from t_order where user_id = ?";
        return getList(sql, id);
    }


}

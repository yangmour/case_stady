package com.xiwen.bookstore.dao.impl;

import com.xiwen.bookstore.bean.OrderItem;
import com.xiwen.bookstore.dao.BaseDao;
import com.xiwen.bookstore.dao.OrderItemDao;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/28 -17:00
 * @Version: 1.0
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public boolean insert(OrderItem orderItem) {
        String sql = "insert into t_order_item values(null,?,?,?,?,?,?)";

        update(sql, orderItem.getBookName(),
                orderItem.getPrice(),
                orderItem.getImgPath(),
                orderItem.getItemCount(),
                orderItem.getItemAmount(),
                orderItem.getOrderId());
        return true;
    }

    @Override
    public List<OrderItem> getByOrderId(Integer orderId) {
        String sql = "select item_Id itemId,book_name bookName,price,img_path imgPath,item_count itemCount,item_amount itemAmount,order_id orderId from t_order_item where order_id =?";
        return getList(sql, orderId);
    }
}

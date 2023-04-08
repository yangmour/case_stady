package com.xiwen.dao.impl;

import com.xiwen.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -16:20
 * @Version: 1.0
 */
//@Component
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void getName() {
        System.out.println("成功");
    }
}

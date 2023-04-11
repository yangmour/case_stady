package com.xiwen.service;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/11 -10:05
 * @Version: 1.0
 */
public interface Cashier {

    void checkout(int userId, List<String> ids);
}

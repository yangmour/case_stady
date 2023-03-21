package com.xiwen.service;

import com.xiwen.bean.Soldier;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -18:30
 * @Version: 1.0
 */
public interface SoldierService {
    List<Soldier> getAll();

    boolean saveSoldier(Soldier soldier);

    boolean update(Soldier soldier);

    boolean delete(Integer integer);
}

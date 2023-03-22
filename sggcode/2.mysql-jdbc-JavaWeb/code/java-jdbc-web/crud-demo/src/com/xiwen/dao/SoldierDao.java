package com.xiwen.dao;

import com.xiwen.bean.Soldier;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -18:34
 * @Version: 1.0
 */
public interface SoldierDao {
    List<Soldier> getAll();

    boolean saveSoldier(Soldier soldier);

    boolean update(Soldier soldier);

    boolean delete(Integer id);

    Soldier getById(String soldierId);
}

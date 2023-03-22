package com.xiwen.dao.impl;

import com.xiwen.bean.Soldier;
import com.xiwen.dao.BaseDao;
import com.xiwen.dao.SoldierDao;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -18:35
 * @Version: 1.0
 */
public class SoldierDaoImpl extends BaseDao<Soldier> implements SoldierDao {

    @Override
    public List<Soldier> getAll() {
        String sql = "select soldier_id soldierId,soldier_name soldierName,soldier_weapon soldierWeapon from t_soldier";
        return getList(sql);
    }

    @Override
    public boolean saveSoldier(Soldier soldier) {

        String sql = "insert into t_soldier values(null,?,?)";
        return update(sql, soldier.getSoldierName(), soldier.getSoldierWeapon());
    }

    @Override
    public boolean update(Soldier soldier) {
        String sql = "update t_soldier set soldier_name=?,soldier_weapon=?  where soldier_id = ?";
        return update(sql, soldier.getSoldierName(), soldier.getSoldierWeapon(), soldier.getSoldierId());
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "delete from t_soldier where soldier_id = ?";
        return update(sql, id);
    }

    @Override
    public Soldier getById(String soldierId) {
        String sql = "select soldier_id soldierId,soldier_name soldierName,soldier_weapon soldierWeapon from t_soldier where soldier_id = ?";
        return getBean(sql, soldierId);
    }
}

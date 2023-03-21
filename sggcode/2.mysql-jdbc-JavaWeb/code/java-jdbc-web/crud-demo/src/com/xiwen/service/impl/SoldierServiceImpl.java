package com.xiwen.service.impl;

import com.xiwen.bean.Soldier;
import com.xiwen.dao.SoldierDao;
import com.xiwen.dao.impl.SoldierDaoImpl;
import com.xiwen.service.SoldierService;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -18:31
 * @Version: 1.0
 */
public class SoldierServiceImpl implements SoldierService {

    private SoldierDao soldierDao = new SoldierDaoImpl();

    @Override
    public List<Soldier> getAll() {
        return soldierDao.getAll();
    }

    @Override
    public boolean saveSoldier(String name, String weapon) {
        Soldier soldier = new Soldier(name, weapon);
        return soldierDao.saveSoldier(soldier);
    }

    @Override
    public boolean update(Integer id, String name, String weapon) {
        Soldier soldier = new Soldier(id, name, weapon);
        return soldierDao.update(soldier);
    }

    @Override
    public boolean delete(Integer id) {

        return soldierDao.delete(id);
    }

}
